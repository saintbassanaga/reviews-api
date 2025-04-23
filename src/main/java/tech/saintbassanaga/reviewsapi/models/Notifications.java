package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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