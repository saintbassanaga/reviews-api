/**
 * Root package for the Reviews API application.
 * 
 * <p>This package contains the main application class {@link tech.saintbassanaga.reviewsapi.ReviewsApiApplication},
 * which serves as the entry point for the Spring Boot application. The application provides a RESTful API
 * for managing product reviews, user accounts, and related functionality.</p>
 * 
 * <p>The application is organized into several subpackages:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models}: Contains the domain model entities</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories}: Contains data access interfaces</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.services}: Contains business service interfaces</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.dtos}: Contains data transfer objects</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config}: Contains configuration classes</li>
 * </ul>
 * 
 * <p>The Reviews API is built using Spring Boot and follows a layered architecture pattern,
 * separating concerns between data access, business logic, and presentation layers. It uses
 * Spring Security with JWT for authentication and authorization, and Spring Data JPA for
 * data persistence.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.models
 * @see tech.saintbassanaga.reviewsapi.repositories
 * @see tech.saintbassanaga.reviewsapi.services
 * @see tech.saintbassanaga.reviewsapi.config
 */
package tech.saintbassanaga.reviewsapi;