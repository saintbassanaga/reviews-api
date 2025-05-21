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
    /**
     * The category or nature of the notification.
     * This field helps classify notifications for filtering and display purposes.
     * Examples might include "review_comment", "moderation_update", etc.
     */
    private String type;

    /**
     * The content or body of the notification.
     * This contains the actual information to be conveyed to the user.
     */
    private String message;

    /**
     * The user who will receive this notification.
     * This establishes a mandatory many-to-one relationship with the Users entity.
     * Changes to the associated user will cascade to this notification.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    /**
     * Indicates whether the notification has been read by the user.
     * A value of true means the notification has been viewed by the user,
     * while false indicates it is still unread.
     */
    private boolean read;

}
