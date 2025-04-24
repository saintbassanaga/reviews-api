package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Comments;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comments, UUID> {
}