package tech.saintbassanaga.reviewsapi.services;

import tech.saintbassanaga.reviewsapi.models.Products;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Interface for managing product-related operations.
 * Provides methods for adding, searching, and deleting products.
 */

public interface ProductService {
    String addProduct(Products product);
    CompletableFuture<List<UUID>> findProductByName(String productName);
    void deleteProductByUuid(UUID productId);
}
