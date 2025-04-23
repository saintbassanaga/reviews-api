/*
package tech.saintbassanaga.reviewsapi.services;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

*/
/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project ProMan at Tue - 3/18/25
 *//*

@Component
public class AuditorAware implements AuditorAware<String> {
    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails userDetails) {
                        return userDetails.getUsername();
                    }
                    return authentication.getPrincipal().toString();
                })
                // Ensure it never returns an empty Optional
                .filter(username -> username == null || !username.isEmpty())
                .or(() -> Optional.of("SYSTEM")); // Default value when no user is authenticated
    }
}*/
