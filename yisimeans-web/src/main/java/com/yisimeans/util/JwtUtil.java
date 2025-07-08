package com.yisimeans.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具類
 */


public class JwtUtil {

    private static final String SECRET_KEY = "eWlzaW1lYW5zMzM0NTY3OA=="; // 密鑰
    private static final Date EXPIRATION_TIME = new Date(System.currentTimeMillis() + 86400000); // token有效時間

    // 生成token
    public static String generateJwt(Map<String, Object> claims) {
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).addClaims(claims).setExpiration(EXPIRATION_TIME).compact();
        return token;
    }

    // 解析token
    public static Claims parseJwt(String token) {
        Claims claims = (Claims)Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims;
    }
}