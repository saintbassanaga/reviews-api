/**
 * This module defines the Reviews API application.
 * 
 * <p>The Reviews API is a Spring Boot application that provides a RESTful API for managing
 * product reviews, user accounts, and related functionality. It uses Spring Security with
 * JWT for authentication and authorization, and Spring Data JPA for data persistence.</p>
 * 
 * <p>This module exports the following packages:</p>
 * <ul>
 *   <li>tech.saintbassanaga.reviewsapi: The root package containing the main application class</li>
 *   <li>tech.saintbassanaga.reviewsapi.models: Domain model entities</li>
 *   <li>tech.saintbassanaga.reviewsapi.models.embeded: Embedded model classes</li>
 *   <li>tech.saintbassanaga.reviewsapi.repositories: Data access interfaces</li>
 *   <li>tech.saintbassanaga.reviewsapi.services: Business service interfaces</li>
 *   <li>tech.saintbassanaga.reviewsapi.services.impls: Business service implementations</li>
 *   <li>tech.saintbassanaga.reviewsapi.dtos: Data transfer objects</li>
 *   <li>tech.saintbassanaga.reviewsapi.config.handlers: Exception handlers</li>
 *   <li>tech.saintbassanaga.reviewsapi.config.security: Security configuration</li>
 *   <li>tech.saintbassanaga.reviewsapi.config.security.jose: JWT security</li>
 * </ul>
 * 
 * <p>This module requires the following modules:</p>
 * <ul>
 *   <li>java.base: The fundamental Java SE module</li>
 *   <li>java.sql: For JDBC database access</li>
 *   <li>spring.boot: Spring Boot core</li>
 *   <li>spring.context: Spring application context</li>
 *   <li>spring.beans: Spring bean factory</li>
 *   <li>spring.data.jpa: Spring Data JPA</li>
 *   <li>spring.web: Spring Web MVC</li>
 *   <li>spring.security.core: Spring Security core</li>
 *   <li>spring.security.web: Spring Security web</li>
 *   <li>spring.security.oauth2.resource.server: OAuth2 resource server</li>
 *   <li>jakarta.persistence: JPA API</li>
 *   <li>lombok: Project Lombok for boilerplate reduction</li>
 * </ul>
 * 
 * @see tech.saintbassanaga.reviewsapi.ReviewsApiApplication
 */
module tech.saintbassanaga.reviewsapi {
    // Export all packages
    exports tech.saintbassanaga.reviewsapi;
    exports tech.saintbassanaga.reviewsapi.models;
    exports tech.saintbassanaga.reviewsapi.models.embeded;
    exports tech.saintbassanaga.reviewsapi.repositories;
    exports tech.saintbassanaga.reviewsapi.services;
    exports tech.saintbassanaga.reviewsapi.services.impls;
    exports tech.saintbassanaga.reviewsapi.dtos;
    // Note: tech.saintbassanaga.reviewsapi.config is not exported as it contains only package-info.java
    exports tech.saintbassanaga.reviewsapi.config.handlers;
    exports tech.saintbassanaga.reviewsapi.config.security;
    exports tech.saintbassanaga.reviewsapi.config.security.jose;

    // Required modules

    // Spring Boot and related modules
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.security.core;
    requires spring.security.web;
    requires spring.security.config;
    requires spring.security.oauth2.resource.server;
    requires spring.security.oauth2.jose;

    // Jakarta EE modules
    // Jakarta Servlet API is included transitively through Spring Web

    // Other dependencies
    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires org.hibernate.validator;
    requires org.apache.tomcat.embed.core;
    requires jakarta.persistence;
    requires com.nimbusds.jose.jwt;
    requires org.slf4j;

    // Open packages for reflection (needed for Spring, JPA, etc.)
    opens tech.saintbassanaga.reviewsapi to spring.core, spring.beans, spring.context;
    opens tech.saintbassanaga.reviewsapi.models to spring.core, org.hibernate.orm.core, spring.data.jpa;
    opens tech.saintbassanaga.reviewsapi.models.embeded to spring.core, org.hibernate.orm.core;
    opens tech.saintbassanaga.reviewsapi.repositories to spring.core, spring.beans, spring.data.jpa;
    opens tech.saintbassanaga.reviewsapi.services to spring.core, spring.beans;
    opens tech.saintbassanaga.reviewsapi.services.impls to spring.core, spring.beans;
    opens tech.saintbassanaga.reviewsapi.config to spring.core, spring.beans, spring.context;
    opens tech.saintbassanaga.reviewsapi.config.handlers to spring.core, spring.beans;
    opens tech.saintbassanaga.reviewsapi.config.security to spring.core, spring.beans;
    opens tech.saintbassanaga.reviewsapi.config.security.jose to spring.core, spring.beans;
    opens tech.saintbassanaga.reviewsapi.dtos to spring.core, com.fasterxml.jackson.databind;
}
