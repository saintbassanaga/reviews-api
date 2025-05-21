package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents a category entity in the system.
 * <p>
 * Categories are used to classify and organize products within the application.
 * Each product belongs to a specific category, allowing for better organization
 * and filtering of products.
 * <p>
 * This entity is mapped to the "Categories" table in the database.
 * <p>
 * Key attributes:
 * - `id`: The unique identifier for the category.
 * - `name`: The name of the category.
 */
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Categories {
    /**
     * Unique identifier for the category.
     * Automatically generated as a UUID when a new category is persisted.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * The name of the category.
     * This field is used to identify and display the category to users.
     */
    private String name;

}
