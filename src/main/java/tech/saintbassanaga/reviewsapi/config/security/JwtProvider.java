package tech.saintbassanaga.reviewsapi.config.security;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;
import tech.saintbassanaga.reviewsapi.models.Users;
import tech.saintbassanaga.reviewsapi.services.AuthService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * JwtProvider is a component responsible for generating JWT tokens for user authentication.
 * It utilizes a combination of services and encoders to authenticate a user and produce
 * a secure access token with the appropriate claims.

 * This class is typically used in authentication workflows to handle the creation and association
 * of JWT tokens to user credentials. It ensures that the generated tokens can be used for secure
 * communication and authorization within the system.

 * Responsibilities:
 * - Authenticate a user with the provided username and password.
 * - Generate a secure JWT token with user-specific claims.
 * - Add essential claims such as issued time, expiration time, issuer details, and user scope.

 * Dependencies:
 * - AuthenticationManager: Used to authenticate user credentials.
 * - AuthService: Service to retrieve user details and validate the user exists.
 * - JwtEncoder: Encodes the JWT with claims for secure transmission.
 */
@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final AuthenticationManager authenticationManager;
    private final AuthService userService;
    private final JwtEncoder jwtEncoder;

    public Map<String, Object> generateUserTokens(String username, String password) {
        return new HashMap<>(generateAccessToken(username, password));
    }

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private Map<String, Object> generateAccessToken(String username, String password) {
        Users user = userService.findUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        logger.info("GENERATE ACCESS TOKEN :::: {}", user);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String scope = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        return buildAccessToken(user, scope);
    }


    private Map<String, Object> buildAccessToken(Users user, String scope) {
        Instant instant = Instant.now();
        int accessTokenTimeOut = 12;
        Instant tokenExpireAt = instant.plus(accessTokenTimeOut, ChronoUnit.HOURS);

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(user.getCredentials().getUsername())
                .issuedAt(instant)
                .expiresAt(tokenExpireAt)
                .issuer("ProMan")
                .claim("scope", scope)
                .claim("user", user) // Replace with relevant user info
                .build();

        String jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();

        Map<String, Object> token = new HashMap<>();
        token.put("access_token", jwtAccessToken);
        token.put("access_generate_at", instant.toString()); // Use formatted string
        token.put("access_expires_in", accessTokenTimeOut);
        return token;
    }

}

