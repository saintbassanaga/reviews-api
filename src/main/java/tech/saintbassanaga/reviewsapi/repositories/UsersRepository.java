package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Users;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}