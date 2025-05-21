package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents media content associated with a review in the system.
 *
 * This entity is mapped to the "ReviewMedia" table in the database and extends
 * {@link AbstractEntity}, inheriting common entity attributes such as `id`,
 * `timestamps`, and audit information. It is used to store media details
 * such as the media type and URL, which are linked to a specific review.
 *
 * Key attributes:
 * - `mediaType`: Defines the type of the media (e.g., image, video, etc.).
 * - `mediaUrl`: Stores the URL or location of the media content.
 *
 * Key relationships:
 * - Maintains a mandatory `@OneToOne` relationship with {@link Reviews}, linking
 *   this media to a specific review while enabling cascaded persistence and
 *   removal operations. The link is ensured using a foreign key constraint on
 *   the `reviewId` column.
 */
@Getter
@Setter
@Entity
@Table(name = "ReviewMedia")
public class ReviewMedia extends AbstractEntity {
    /**
     * The type of media content associated with the review.
     * This field indicates the format or category of the media, such as "image", "video", "audio", etc.
     */
    private String mediaType;

    /**
     * The URL or location where the media content is stored.
     * This could be a file path, a URL to a cloud storage location, or any other reference
     * that allows the application to retrieve and display the media.
     */
    private String mediaUrl;

    /**
     * The review that this media is associated with.
     * This establishes a one-to-one relationship with the Reviews entity,
     * meaning each media entry is linked to exactly one review.
     * The orphanRemoval attribute ensures that if the review is deleted,
     * this media entry will also be removed.
     */
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "reviewId", nullable = false)
    private Reviews reviews;

}
