package com.kedu.board.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.expiration}")
    private long exp;

    private Algorithm algorithm;
    private JWTVerifier jwt;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.algorithm = Algorithm.HMAC256(secret); // 가장 가볍고 빠른 동작을 냄
        this.jwt = JWT.require(algorithm).build();
    }

    public String createToken(String id) {
        // 토큰을 만들고 ,
        // 토큰에서 가장 많이쓰이는 대표데이터,
        // claim으로 이름을 줌,
        // 토큰 발급 시간
        // 토큰 만료 시간
        return JWT.create()
                .withSubject(id)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + exp))
                .sign(algorithm);

    }

    public DecodedJWT verifyToken(String token){
        return jwt.verify(token);
    }
}
