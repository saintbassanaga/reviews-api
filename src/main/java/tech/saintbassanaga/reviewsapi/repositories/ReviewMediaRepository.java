package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.ReviewMedia;

import java.util.UUID;

public interface ReviewMediaRepository extends JpaRepository<ReviewMedia, UUID> {
}