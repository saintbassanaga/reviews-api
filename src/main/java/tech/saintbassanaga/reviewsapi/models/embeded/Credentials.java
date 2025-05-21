package tech.saintbassanaga.reviewsapi.models.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

/**
 * Represents the authentication credentials for a user in the system.
 * 
 * This embeddable class encapsulates the core authentication information required
 * for user identification and login, including username, password, and email.
 * It is designed to be embedded within the {@link tech.saintbassanaga.reviewsapi.models.Users}
 * entity to maintain a clean separation of concerns.
 * 
 * The class enforces uniqueness constraints on both username and email fields
 * to ensure that each user has distinct credentials in the system.
 */
@Getter
@Setter
@Embeddable
@UniqueElements
public class Credentials {

    /**
     * The unique identifier used by the user to log in to the system.
     * This field is required and must be unique across all users.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * The secret authentication token used to verify the user's identity.
     * This field should be securely stored, typically in an encrypted or hashed form.
     */
    private String password;

    /**
     * The user's email address for communication and account recovery.
     * This field is required and must be unique across all users.
     */
    @Column(nullable = false,unique = true)
    private String email;
}
