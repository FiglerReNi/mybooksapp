package hu.tmx.mybooksapp.util.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface Jwt {

    String generateToken(UserDetails userDetails);

    boolean validateToken(UserDetails userDetails, String token);
}
