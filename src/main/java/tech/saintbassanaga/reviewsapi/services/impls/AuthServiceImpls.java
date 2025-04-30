package tech.saintbassanaga.reviewsapi.services.impls;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.reviewsapi.models.Users;
import tech.saintbassanaga.reviewsapi.services.AuthService;

import java.util.Optional;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */

@Service
public class AuthServiceImpls implements AuthService {
    @Override
    public Optional<Users> findUser(String username) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new Users();
    }
}
