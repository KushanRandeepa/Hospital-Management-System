package edu.icet.security;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtUtils {


    private final SecretKey secretKey;

    public JwtUtils() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(UserDetails userDetails ) {

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(secretKey)
                .compact();
    }


    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}


