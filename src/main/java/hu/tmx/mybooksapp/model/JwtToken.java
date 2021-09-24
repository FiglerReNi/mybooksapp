package hu.tmx.mybooksapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public class JwtToken {

    private final String jwtToken;


}
