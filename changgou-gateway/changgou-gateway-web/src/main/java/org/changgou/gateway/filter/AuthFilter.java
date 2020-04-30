package org.changgou.gateway.filter;

import com.changgou.utils.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.changgou.gateway.service.AuthService;
import org.changgou.gateway.utils.UrlFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/****
 * @Author:ky2009666
 * @Description: 定义权限管理过滤器
 * @Date 2020/4/29 0:18
 *****/
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    /**
     * 定义token的句柄
     */
    private static final String TOKEN = "token";
    /**
     * 定义权限获取的服务
     */
    @Resource
    private AuthService authService;

    /**
     * 进行全局拦截
     *
     * @param exchange Contract for an HTTP request-response interaction
     * @param chain    Contract to allow a {@link WebFilter} to delegate to the next in the chain.
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String token = null;
        //1.判断当前请求路径是否为登录请求,如果是,则直接放行
        String path = request.getURI().getPath();
        if ("/user/login".equals(path) || !UrlFilter.hasAuthorize(path)) {
            //直接放行
            return chain.filter(exchange);
        }
        token = request.getHeaders().getFirst(TOKEN);
        if (org.springframework.util.StringUtils.isEmpty(token)) {
            //2.从cookie中获取jti的值,如果该值不存在,拒绝本次访问
            token = authService.getJtiFromCookie(request);
        }
        if (StringUtils.isEmpty(token)) {
            //3.从redis中获取jwt的值,如果该值不存在,拒绝本次访问
            token = authService.getJwtFromRedis(TOKEN);
            if (StringUtils.isEmpty(token)) {
                //拒绝访问
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
        }
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            //拒绝访问
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //4.对当前的请求对象进行增强,让它会携带令牌的信息
        request.mutate().header("Authorization", "Bearer " + token);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
