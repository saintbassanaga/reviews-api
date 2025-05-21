/**
 * This package contains security configuration classes for the Reviews API application.
 * 
 * <p>The classes in this package are responsible for configuring and implementing the
 * security aspects of the application, including authentication, authorization, and
 * protection against common web vulnerabilities. They leverage Spring Security to
 * provide a robust security framework.</p>
 * 
 * <p>Key security components in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.SecurityConfig}: The main
 *       security configuration class that sets up authentication providers, security filters,
 *       URL-based access rules, and other security-related settings.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.JwtProvider}: Handles the
 *       creation, validation, and parsing of JSON Web Tokens (JWT) used for stateless
 *       authentication in the application.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.CROSFilter}: Implements
 *       Cross-Origin Resource Sharing (CORS) filtering to control which domains can
 *       access the API resources.</li>
 * </ul>
 * 
 * <p>These security components work together to ensure that the application is protected
 * against unauthorized access and common security vulnerabilities, while providing a
 * seamless authentication experience for legitimate users.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.config.handlers
 * @see tech.saintbassanaga.reviewsapi.config.security.jose
 * @see tech.saintbassanaga.reviewsapi.services.AuthService
 */
package tech.saintbassanaga.reviewsapi.config.security;