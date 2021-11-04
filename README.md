# Periodic Table REST API

## Setup

### Prerequisites
    1. Java 8 
    2. Maven
    3. Docker

### Startup first time
    Open a terminal (git bash)
    1. run `docker-compose up` - this starts up our PostgreSQL DB instance inside a Docker container
    2. run `mvn clean install` - this downloads and configures all of the required dependencies
    3. open `src/main/resources/application.properties` and change `spring.jpa.hibernate.ddl-auto` value to `create`. This would make the startup process create the database tables. Afterwards it is recommended to change it to `update` in order to not delete the DB everytime we start the service.
    4. run `mvn spring-boot:start` - this starts the application on localhost:8080
    5. (Optional) Change the value of `spring.jpa.hibernate.ddl-auto` to `update` in order to not delete the tables next time app starts
