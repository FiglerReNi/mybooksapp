package hu.tmx.mybooksapp.util.impl;

import hu.tmx.mybooksapp.util.Jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtImpl implements Jwt {

    private final String secretKey;

    public JwtImpl(@Value("${security.secretKey}") String secretKey) {
        this.secretKey = secretKey;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }

    public boolean validateToken(UserDetails userDetails, String token) {
        return (extractAllClaims(token).getSubject().equals(userDetails.getUsername()) && !extractAllClaims(token).getExpiration().before(new Date()));
    }


}
