package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Histories;

import java.util.UUID;

public interface HistoriesRepository extends JpaRepository<Histories, UUID> {
}