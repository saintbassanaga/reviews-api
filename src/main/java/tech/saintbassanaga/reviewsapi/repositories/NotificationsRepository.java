package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Notifications;

import java.util.UUID;

public interface NotificationsRepository extends JpaRepository<Notifications, UUID> {
}