package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a notification within the system. Notifications are created to inform users
 * about certain events or updates. Each notification is associated with a specific user
 * and can have a type, a message, and a read status.
 *
 * This entity is mapped to the "Notifications" table in the database.
 *
 * Key features:
 * - Contains a `type` field to specify the category or nature of the notification.
 * - Includes a `message` field to store the content of the notification.
 * - Maintains a many-to-one relationship with the {@link Users} entity, indicating the
 *   user associated with the notification.
 * - Tracks the read status of the notification using a boolean `read` field.
 *
 * This class extends {@link AbstractEntity}, inheriting common entity attributes such as
 * `id`, timestamps, and audit information.
 */
@Getter
@Setter
@Entity
@Table(name = "Notifications")
public class Notifications extends AbstractEntity {
    private String type;

    private String message;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    private boolean read;

}