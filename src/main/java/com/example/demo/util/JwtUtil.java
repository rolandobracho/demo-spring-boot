package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.key}")
    private String keyJwt;

    @Value("${jwt.cookie.name}")
    private String jwtCookie;

    @Value("${jwt.token.expire}")
    private int jwtTokenExpire;

    public String createToken(String username) throws IOException {

        logger.info("Action={}", "Here ...");

        Date validity = new DateTime().plusSeconds(jwtTokenExpire).toDate();
        return Jwts.builder()
                .setSubject(username)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, keyJwt)
                .setExpiration(validity)
                .compact();
    }

    private String generateToken(Map<String, Object> claims, Date fechaExpiracion) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(fechaExpiracion)//Se genera una nueva fecha de expiracion
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, keyJwt) //Se firma y codifica el token
                .compact();
    }

}

