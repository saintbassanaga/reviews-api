package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents a trust level entity within the system. A trust level is an essential part of defining
 * the credibility or reputation level of a user based on system-defined criteria.
 *
 * This entity is mapped to the "TrustLevel" table in the database and contains details like the
 * trust level ID, name, and description.
 *
 * Key attributes:
 * - `id`: Uniquely identifies a trust level in the system.
 * - `name`: Denotes the name of the trust level (e.g., "Silver", "Gold", "Platinum").
 * - `description`: Provides additional information or context about the trust level.
 *
 * This entity is utilized in associations with other entities such as Users to define their
 * trust level, influencing permissions, actions, or access within the system.
 */
@Getter
@Setter
@Entity
@Table(name = "TrustLevel")

public class TrustLevel {
    /**
     * Unique identifier for the trust level.
     * Automatically generated as a UUID when a new trust level is persisted.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * The name of the trust level.
     * This field represents the designation of the trust level, such as "Bronze", "Silver", "Gold", etc.,
     * which indicates the user's reputation or credibility level in the system.
     */
    private String name;

    /**
     * Additional details about the trust level.
     * This field provides a more detailed explanation of what the trust level represents,
     * its criteria, benefits, or any other relevant information.
     */
    private String description;

}
