package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Votes;

import java.util.UUID;

public interface VotesRepository extends JpaRepository<Votes, UUID> {
}