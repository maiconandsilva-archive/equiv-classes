package io.github.maiconandsilva.equivclasses.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.maiconandsilva.equivclasses.data.entities.AcademicUser;
import io.github.maiconandsilva.equivclasses.utils.dtos.UserLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParseException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${app.sec.time-to-expiration}")
    private Long timeToExpiration;

    @Value("${app.sec.issuer}")
    private String issuer;

    private static final String KEY = "spring.jwt.sec";

    public String generateToken(Authentication user) throws JsonProcessingException {
        AcademicUser academicUser = (AcademicUser) user.getPrincipal();
        UserLogin userLogin = new UserLogin(
                academicUser.getUsername(),
                academicUser.getPassword(),
                academicUser.getAuthorities());

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userLogin);
        return Jwts.builder().claim("userDetails", userJson)
            .setIssuer(issuer)
            .setSubject(user.getName())
            .setExpiration(new Date(new Date().getTime() + timeToExpiration))
            .signWith(SignatureAlgorithm.HS512, KEY).compact();
    }

    public Authentication parseToken(String token) throws JsonParseException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson =
            Jwts.parser().setSigningKey(KEY).parseClaimsJws(token)
                .getBody().get("userDetails", String.class);
        UserLogin user = mapper.readValue(credentialsJson, UserLogin.class);

        return new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}
