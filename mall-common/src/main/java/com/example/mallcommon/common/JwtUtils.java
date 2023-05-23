package com.example.mallcommon.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtils {

    private static final byte[] secretBytes = "your_secret_string_that_should_be_long_enough_for_HS256".getBytes(StandardCharsets.UTF_8);
    private static final SecretKey key = Keys.hmacShaKeyFor(secretBytes);

    private static final long expirationTime = 3600000; // 1 hour in milliseconds

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }

    public static Claims decodeToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            throw new RuntimeException("Invalid token.");
        }
    }
}
