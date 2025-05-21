package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product entity within the system.
 * This entity is used to store information about products, including their name, description,
 * and associated category. It is mapped to the "Products" table in the database.
 *
 * Key attributes:
 * - `name`: The name of the product.
 * - `description`: A textual description of the product.
 * - `categories`: A mandatory many-to-one relationship with the {@link Categories} entity,
 *   representing the category the product belongs to.
 *
 * This class extends {@link AbstractEntity}, inheriting common entity attributes such as
 * `id`, `timestamps`, and audit information.
 */
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Products extends AbstractEntity {
    private String name;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoriesId", nullable = false)
    private Categories categories;

}