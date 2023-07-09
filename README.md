# LocationService
Location service for scheduling appointment

1. Create a location based on the customer requirements. It holds the locationId, locationMeaning and resourceId.
2. Before creating the location, customer needs to create a [resource](https://github.com/akhilP7/ResourceService).
3. To create a location, customer should have a resourceId which will be generated from the ResourceService.
4. Using rest template, we made a connection to resource service to retrieve resourceDetails.

# Dependency_Repositories

1. [CONFIG_SERVER](https://github.com/akhilP7/Config-Server) - connection to the cloud config server GIT
2. [SERVICE_REGISTRY](https://github.com/akhilP7/Service-Registry) - acts as a central repository where services can register themselves and provide information about their location and availability.
3. [RESOURCE_SERVICE](https://github.com/akhilP7/ResourceService)
4. [SPRING_CONFIG_SERVER](https://github.com/akhilP7/spring-config-server) - holds EUREKA_SERVER_ADDRESS

# Dependencies

1. Spring Web (WEB) - Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
2. Spring Data JPA (SQL) - Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
3. Config Client (SPRING CLOUD CONFIG) - Client that connects to a Spring Cloud Config Server to fetch the application's configuration.
4. Spring Boot DevTools (DEVELOPER TOOLS) - Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
5. Eureka Discovery Client (SPRING CLOUD DISCOVERY) - A REST based service for locating services for the purpose of load balancing and failover of middle-tier servers.
6. Spring Boot Actuator (OPS) - Supports built in (or custom) endpoints that let you monitor and manage your application - such as application health, metrics, sessions, etc. 
7. Cloud Bootstrap (SPRING CLOUD) - Non-specific Spring Cloud features, unrelated to external libraries or integrations (e.g. Bootstrap context and @RefreshScope).
8. Lombok (DEVELOPER TOOLS) - Java annotation library which helps to reduce boilerplate code.
