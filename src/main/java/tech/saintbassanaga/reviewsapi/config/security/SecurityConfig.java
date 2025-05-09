package tech.saintbassanaga.reviewsapi.config.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tech.saintbassanaga.reviewsapi.config.handlers.CustomAccessDeniedHandler;
import tech.saintbassanaga.reviewsapi.config.handlers.CustomAuthenticationHandler;
import tech.saintbassanaga.reviewsapi.config.security.jose.PersistentJwks;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    // PersistentJwks is used to manage RSA keys for JWT signing and verification.
    private final PersistentJwks persistentJwks;

    // PasswordEncoder is used to encode and verify user passwords.
    private final PasswordEncoder passwordEncoder;

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object to configure security settings
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Disables CSRF protection.
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**")
                        .permitAll() // Allows public access to Swagger and API documentation.
                        .anyRequest().permitAll()) // Permits all other requests (can be changed to authenticated()).
                .oauth2ResourceServer(OAuth2 -> OAuth2.jwt(Customizer.withDefaults())) // Configures OAuth2 resource server with JWT.
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sets session management to stateless.
                .httpBasic(Customizer.withDefaults()) // Enables HTTP Basic authentication.
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new CustomAuthenticationHandler()) // Custom handler for authentication failures.
                        .accessDeniedHandler(new CustomAccessDeniedHandler()) // Custom handler for access denied errors.
                )
                .build();
    }

    /**
     * Configures the AuthenticationManager with a DaoAuthenticationProvider.
     *
     * @param userDetailsService the UserDetailsService to load user-specific data
     * @return the configured AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setPasswordEncoder(passwordEncoder); // Sets the password encoder.
        daoAuthProvider.setUserDetailsService(userDetailsService); // Sets the user details service.
        return new ProviderManager(daoAuthProvider); // Returns a ProviderManager with the configured provider.
    }

    /**
     * Provides a JWKSource for managing JSON Web Keys (JWK).
     *
     * @return the configured JWKSource
     */
    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        RSAKey rsaKey = persistentJwks.getRsaKey(); // Retrieves the RSA key.
        JWKSet jwkSet = new JWKSet(rsaKey); // Creates a JWKSet with the RSA key.
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet); // Returns a JWKSource for key selection.
    }

    /**
     * Configures a JwtEncoder for encoding JWTs.
     *
     * @param jwkSource the JWKSource used for signing JWTs
     * @return the configured JwtEncoder
     */
    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource); // Creates a NimbusJwtEncoder with the provided JWKSource.
    }

    /**
     * Configures a JwtDecoder for decoding JWTs.
     *
     * @return the configured JwtDecoder
     * @throws RuntimeException if an error occurs while creating the decoder
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        try {
            return NimbusJwtDecoder.withPublicKey(persistentJwks.getPublicKey()).build(); // Creates a JwtDecoder with the public key.
        } catch (JOSEException e) {
            throw new RuntimeException(e); // Wraps and rethrows JOSEException as a RuntimeException.
        }
    }
}