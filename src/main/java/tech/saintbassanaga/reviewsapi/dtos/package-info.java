/**
 * This package contains Data Transfer Objects (DTOs) used for transferring data between layers.
 * 
 * <p>DTOs in this package are used to encapsulate data for transfer between different layers
 * of the application, particularly between the service layer and the presentation layer.
 * They help to decouple the domain model from the presentation layer, allowing each to
 * evolve independently.</p>
 * 
 * <p>These objects are typically simple POJOs (Plain Old Java Objects) with fields, getters,
 * and setters, and may include validation annotations. They do not contain business logic
 * but may include data transformation or formatting logic specific to the presentation needs.</p>
 * 
 * <p>Key DTOs in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.dtos.ApiResponse}: A standardized structure for
 *       HTTP responses in the application, providing a consistent format for success and error responses.</li>
 * </ul>
 * 
 * <p>Additional DTOs may be added as needed to support specific data transfer requirements
 * between different parts of the application.</p>
 */
package tech.saintbassanaga.reviewsapi.dtos;