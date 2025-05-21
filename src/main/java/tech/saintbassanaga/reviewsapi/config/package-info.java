/**
 * This package contains configuration classes for the Reviews API application.
 * 
 * <p>The configuration classes in this package and its subpackages are responsible for
 * setting up various aspects of the application, including security, exception handling,
 * and other infrastructure concerns. These classes typically use Spring's configuration
 * annotations such as {@code @Configuration}, {@code @EnableWebSecurity}, etc.</p>
 * 
 * <p>The package is organized into several subpackages:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.handlers}: Contains classes for handling
 *       exceptions and authentication/authorization failures</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security}: Contains security configuration
 *       classes, including JWT authentication and CORS configuration</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.jose}: Contains classes related
 *       to JSON Web Key Sets (JWKS) for JWT token signing and verification</li>
 * </ul>
 * 
 * <p>These configuration classes are essential for the proper functioning of the application,
 * ensuring that it is secure, handles errors gracefully, and is properly integrated with
 * the Spring framework.</p>
 */
package tech.saintbassanaga.reviewsapi.config;