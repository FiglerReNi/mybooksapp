package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.entity.User;
import hu.tmx.mybooksapp.model.JwtToken;
import hu.tmx.mybooksapp.util.jwt.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private Jwt jwt;

    @PostMapping("/authenticate")
    public ResponseEntity<Object> createAuthToken(@RequestBody User user) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        }catch(BadCredentialsException exception){
            throw new BadCredentialsException("Incorrect username or password" + exception);
        }
        String jwtToken = jwt.generateToken(userDetailsService.loadUserByUsername(user.getUsername()));
        return ResponseEntity.ok(new JwtToken(jwtToken));
        //        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
//                "status", HttpStatus.OK.value(),
//                "token", new JwtToken(jwtToken)));
    }
}
