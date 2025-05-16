package tech.saintbassanaga.reviewsapi.services.impls;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project Reviews-API at Tue - 4/28/25
 */

@Component
public class AuditorAwareImpls implements AuditorAware<String> {

    @Override
    public @NonNull Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails userDetails) {
                        return userDetails.getUsername();
                    }
                    return authentication.getPrincipal().toString();
                })
                // Ensure it never returns an empty Optional
                .filter(username -> !username.isEmpty())
                .or(() -> Optional.of("SYSTEM")); // Default value when no user is authenticated
    }

}
