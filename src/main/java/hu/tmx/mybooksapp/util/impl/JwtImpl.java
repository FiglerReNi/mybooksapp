package hu.tmx.mybooksapp.util.impl;

import hu.tmx.mybooksapp.util.Jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtImpl implements Jwt {

    private String secretKey = "";

    public JwtImpl(@Value("${security.secretKey}") String secretKey) {
        this.secretKey = secretKey;
    }

//    private void extractAllClaims(String token){
//        checkClaims =
//    }

//    public String extractUsername(){
//        return checkClaims.getSubject();
//    }
//
//    public Date extractExpiration(){
//        return checkClaims.getExpiration();
//    }
//
//    private boolean isTokenExpired(){
//        return extractExpiration().before(new Date());
//    }

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
        Claims checkClaims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
        return (checkClaims.getSubject().equals(userDetails.getUsername()) && !checkClaims.getExpiration().before(new Date()));
    }


}
