package tech.saintbassanaga.reviewsapi.models.embeded;

/**
 * Represents the categorization of roles within the system.
 * 
 * This enum defines the different groups or categories that roles can belong to,
 * providing a way to organize and classify roles based on their function or area
 * of responsibility within the application.
 * 
 * It is used in the {@link tech.saintbassanaga.reviewsapi.models.Role} entity
 * to categorize roles into predefined groups.
 */
public enum RoleGroup {
    /**
     * Represents administrative roles with the highest level of system access and control.
     * Users with roles in this group typically have permissions to manage all aspects of the system.
     */
    ADMIN, 

    /**
     * Represents operational roles focused on day-to-day system operations.
     * Users with roles in this group typically handle routine operational tasks.
     */
    OPERATION, 

    /**
     * Represents developer roles focused on technical aspects of the system.
     * Users with roles in this group typically have permissions related to development and technical maintenance.
     */
    DEVELLOPER, 

    /**
     * Represents project management roles focused on overseeing projects.
     * Users with roles in this group typically have permissions related to project planning, tracking, and coordination.
     */
    PROJECT_MANAGER
}
