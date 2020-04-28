package org.changgou.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/25
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GateWayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayWebApplication.class, args);
    }

    /**
     * 获取用户的唯一的KEY进行限流操作
     *
     * @return KeyResolver
     */
    @Bean(name = "ipKeyResolver")
    public KeyResolver userKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                String ip = exchange.getRequest().getRemoteAddress().getHostString();
                log.info("userIp:{}", ip);
                return Mono.just(ip);
            }
        };
    }
}
