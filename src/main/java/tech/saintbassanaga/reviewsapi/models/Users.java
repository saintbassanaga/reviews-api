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
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
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