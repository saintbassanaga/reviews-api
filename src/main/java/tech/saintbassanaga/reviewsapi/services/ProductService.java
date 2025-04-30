package tech.saintbassanaga.reviewsapi.services;

import tech.saintbassanaga.reviewsapi.models.Products;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */

public interface ProductService {
    String addProduct(Products product);
    CompletableFuture<List<UUID>> findProductByName(String productName);
    void deleteProductByUuid(UUID productId);
}
