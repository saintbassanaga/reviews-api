package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Reviews;

import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
}