package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Moderations")
public class Moderations extends AbstractEntity {
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    private String status;

}