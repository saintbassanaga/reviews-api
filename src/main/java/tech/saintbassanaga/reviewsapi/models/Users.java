package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.saintbassanaga.reviewsapi.models.embeded.Credentials;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * Represents a user entity within the system. A user is uniquely identified by a username and can
 * have specific roles, credentials, and a trust level associated with them.
 * <p>
 * This entity is mapped to the "Users" table in the database and enforces unique constraints on the
 * username field. It implements the UserDetails interface to integrate with Spring Security for
 * authentication and authorization purposes.
 * <p>
 * Key features:
 * - Embeds {@link Credentials} for storing user credentials (username, password, email).
 * - Maintains a one-to-one relationship with {@link TrustLevel} to denote the user's trust level.
 * - Supports many-to-many relationships with {@link Role} to indicate the user's assigned roles.
 * <p>
 * This class extends {@link AbstractEntity}, inheriting common entity attributes such as
 * `id`, `timestamps`, and audit information.
 */
@Getter
@Setter
@Entity
@Table(
        name = "Users",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique", columnNames = "username")
        }
)
public class Users extends AbstractEntity implements UserDetails {
    /**
     * The user's authentication credentials.
     * This embedded object contains the username, password, and email information
     * necessary for user authentication and account management.
     */
    @Embedded
    private Credentials credentials;

    /**
     * The trust level assigned to the user.
     * This establishes a mandatory one-to-one relationship with the TrustLevel entity,
     * indicating the user's reputation or credibility level in the system.
     * If the user is deleted, the orphanRemoval attribute ensures the trust level is not removed.
     */
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "trustLevelId", nullable = false)
    private TrustLevel trustLevel;

    /**
     * The roles assigned to the user.
     * This establishes a many-to-many relationship with the Role entity,
     * allowing a user to have multiple roles and each role to be assigned to multiple users.
     * The relationship is eagerly fetched to ensure roles are always available when a user is loaded.
     * The relationship is mapped through a join table named "UserRoles".
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRoles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Role> roles ;

    /**
     * Retrieves the authorities granted to the user.
     * This determines the roles or permissions the user has within the system.
     *
     * @return a collection of authorities assigned to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return "";
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return "";
    }

/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return credentials.getUsername();
    }*/
}
