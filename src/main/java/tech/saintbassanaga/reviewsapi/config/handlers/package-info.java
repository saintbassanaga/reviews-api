/**
 * This package contains handler classes for managing exceptions and security-related events.
 * 
 * <p>The handler classes in this package are responsible for providing centralized and
 * consistent handling of various exceptional conditions and security events that may occur
 * during the application's operation. They ensure that the application responds appropriately
 * to errors and security challenges.</p>
 * 
 * <p>Key handler classes in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.handlers.RestExceptionHandler}: Provides
 *       centralized exception handling for the REST API, converting exceptions into standardized
 *       HTTP responses with appropriate status codes and error messages.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.handlers.CustomAuthenticationHandler}: Handles
 *       authentication failures in the security framework, providing custom responses when
 *       authentication attempts fail.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.handlers.CustomAccessDeniedHandler}: Handles
 *       access denied scenarios, providing custom responses when authenticated users attempt to
 *       access resources they don't have permission for.</li>
 * </ul>
 * 
 * <p>These handlers work together to ensure that the application provides clear, consistent,
 * and secure responses to various exceptional conditions.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.config.security
 * @see tech.saintbassanaga.reviewsapi.dtos.ApiResponse
 */
package tech.saintbassanaga.reviewsapi.config.handlers;