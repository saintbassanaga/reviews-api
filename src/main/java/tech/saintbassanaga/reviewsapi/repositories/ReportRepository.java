package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Report;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}