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
 *
 * This entity is mapped to the "Users" table in the database and enforces unique constraints on the
 * username field. It implements the UserDetails interface to integrate with Spring Security for
 * authentication and authorization purposes.
 *
 * Key features:
 * - Embeds {@link Credentials} for storing user credentials (username, password, email).
 * - Maintains a one-to-one relationship with {@link TrustLevel} to denote the user's trust level.
 * - Supports many-to-many relationships with {@link Role} to indicate the user's assigned roles.
 *
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
    @Embedded
    private Credentials credentials;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "trustLevelId", nullable = false)
    private TrustLevel trustLevel;

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