package tech.saintbassanaga.reviewsapi.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import tech.saintbassanaga.reviewsapi.models.Users;

import java.util.Optional;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */
public interface AuthService extends UserDetailsService {
    Optional<Users> findUser(String username);
}
