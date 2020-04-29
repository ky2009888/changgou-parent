package com.changgou.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/29
 */
public class JwtUtils {

    /**
     * 秘钥
     */
    private static final String KEY = "ky2009666";
    /**
     * 超时时间30分钟
     */
    private static final long TTL = 30 * 60 * 1000L;

    /**
     * 生成JWT
     *
     * @param id
     * @param subject
     * @param roles
     * @return
     */
    public static String createJWT(String id, String subject, String roles) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder jwt = Jwts.builder().setId(id)
                //主题
                .setSubject(subject)
                //签发时间
                .setIssuedAt(now)
                //签发者
                .setIssuer("ky2009666")
                //签发的算法
                .signWith(SignatureAlgorithm.HS256, KEY)
                //角色
                .claim("roles", roles);
        if (TTL > 0) {
            jwt.setExpiration(new Date(nowMillis + TTL));
        }
        return jwt.compact();
    }

    /**
     * 解析JWT
     *
     * @param jwtStr
     * @return
     */
    public static Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}


