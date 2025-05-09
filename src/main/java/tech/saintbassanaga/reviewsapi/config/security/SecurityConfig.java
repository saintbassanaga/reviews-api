package tech.saintbassanaga.reviewsapi.config.security;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
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

import java.security.interfaces.RSAPrivateKey;


/**
 * @author hmekeng
 * @created 10/03/2025 - 14:56
 * @project mercurial-rest
 * @package com.siic.dgls.mercurial.config.security
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final RsaKeyConfig rsaKeyConfig;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**")
                        .permitAll().anyRequest().permitAll())
                     //   .authenticated())
                .oauth2ResourceServer(OAuth2 -> OAuth2.jwt(Customizer.withDefaults()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling(ex-> ex
                        .authenticationEntryPoint(new CustomAuthenticationHandler())
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
                )
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setPasswordEncoder(passwordEncoder);
        daoAuthProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthProvider);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeyConfig.publicKey()).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeyConfig.publicKey()).privateKey(rsaKeyConfig.privateKey()).build();
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSource);
    }


}
