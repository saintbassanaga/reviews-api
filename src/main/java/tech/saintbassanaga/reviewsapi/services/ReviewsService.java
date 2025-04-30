package tech.saintbassanaga.reviewsapi.services;

import tech.saintbassanaga.reviewsapi.models.Reviews;

import java.util.List;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */
public interface ReviewsService {
    String addReview(Reviews review);
    void deleteReviewByUuid(String reviewId);
    String updateReview(Reviews review);
    Reviews findReviewByUuid(String reviewId);
    List<Reviews> findAllReviews();
    List<Reviews> findReviewsByProduct(String productId);
}
