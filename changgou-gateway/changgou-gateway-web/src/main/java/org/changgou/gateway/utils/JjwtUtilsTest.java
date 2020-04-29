package org.changgou.gateway.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/29
 *
 * @author Lenovo
 */
@Slf4j
public class JjwtUtilsTest {
    private static final String KEY = "ky2009666";
    /**
     * 主方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject("Jwt令牌测试");
        builder.setIssuer("key2009666");
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis()+20000));
        builder.signWith(SignatureAlgorithm.HS256, KEY);
        String token = builder.compact();
        log.info("token:{}", token);
        parseJwt(token);
    }

    /**
     * 解析jwt
     *
     * @param token
     */
    public static void parseJwt(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        log.info("claimsJws:{}",claimsJws.toString());
        Claims body = claimsJws.getBody();
        JwsHeader header = claimsJws.getHeader();
        String subject = body.getSubject();
        log.info("subject:{}",subject);

    }
}
