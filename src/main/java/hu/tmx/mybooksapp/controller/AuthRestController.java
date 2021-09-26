package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.model.JwtToken;
import hu.tmx.mybooksapp.util.jwt.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Map;


@RestController
public class AuthRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private Jwt jwt;

    @GetMapping("/authenticate")
    public ResponseEntity<Object> createAuthToken(@RequestHeader("authorization") String userPass) {
        String[] decodedCredentials;
        String authorizationCredentials = userPass.substring("Basic".length()).trim();
        decodedCredentials = new String(Base64.getDecoder().decode(authorizationCredentials))
                .split(":");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(decodedCredentials[0], decodedCredentials[1])
        );
        JwtToken jwtToken = new JwtToken(jwt.generateToken(userDetailsService.loadUserByUsername(decodedCredentials[0])));
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "token", jwtToken.getJwtToken()));
    }
}
