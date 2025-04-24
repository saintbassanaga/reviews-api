package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Moderations;

import java.util.UUID;

public interface ModerationsRepository extends JpaRepository<Moderations, UUID> {
}