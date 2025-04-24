package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}