package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.TrustLevel;

import java.util.UUID;

public interface TrustLevelRepository extends JpaRepository<TrustLevel, UUID> {
}