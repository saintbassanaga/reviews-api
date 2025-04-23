package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Report")
public class Report extends AbstractEntity {
    private String reason;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;

}