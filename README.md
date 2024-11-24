# SpringBoot-DataIntegrityViolation-Exception

A 'DataIntegrityViolationException' typically occurs in Java applications using Spring Framework (or similar ORM-based tools like Hibernate) when a database operation violates integrity constraints. These constraints ensure the consistency and validity of data in the database.

## Features
- `Spring Boot`: A framework to build stand-alone, production-grade Spring-based applications.
- `Maven`: Dependency management and build automation.
- `JPA`: Java Persistence API for database operations.
- `MariaDB`: Relational database management system used for storing application data.
- `Custom Exception Handling`: Custom exception handling for DataIntegrityViolationException.
- `Validation`: Input validation to prevent data integrity violations.

## Dependencies
-Spring Web
-Spring Data JPA
-Spring Boot DevTools
-MariaDB Driver
-Validation

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MariaDB (can be replaced with any other database)


## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/priyankakushwaha89/Springboot-DataIntegrityViolation-Exception.git
   cd Springboot-DataIntegrityViolation-Exception

2. Configure the database:

    Update the src/main/resources/application.properties file with your database connection details:
     ```sh
   spring.datasource.url=jdbc:mariadb://localhost:3306/DATABASE_NAME
   spring.datasource.username=USERNAME
   spring.datasource.password=YOUR_PASSWORD
   spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=create-drop
   
3. Build the project:
   ```sh
     mvn clean install
4. Run the application:
   ```sh
     mvn spring-boot:run
The application will start on http://localhost:8080.

### Endpoints

1. Test Endpoint
- URL: `/test`
- Method: GET
- Description: Test the API to ensure it's running
- Response: "This is Method Arguement Not Valid Exception Test"

2. Save Data
- URL: `/save`
- Method: POST
- Description: Add new User details.
- Request Body: json in postman
  
  ```sh
  {
        "id": 1,
        "name": "priyanka",
        "phoneno": "9087675434"
    }

3. Get All Users Data
- URL: `/all`
- Method: GET
- Description: Returns a list of all Users details.
  
  ```sh
[
    {
        "id": 1,
        "name": "priyanka",
        "phoneno": "9279149432"
    },
    {
        "id": 2,
        "name": "Roshan",
        "phoneno": "9876543201"
    },
    {
        "id": 3,
        "name": "raha",
        "phoneno": "9786543011"
    }
]

4. Get Users detail by id
- URL: '/id/{id}'
- Method: Get
- Description: Returns a list of user data with id
4. Validation
- Name: Name cannot be null.
- phoneno: Please Enter a valid Phone number.



## Exception Handling
The application includes a global exception handler that captures `DataIntegrityViolationException` and returns a meaningful error response.
```sh
{
  
   "name": "Name cannot be null",
  "phoneno": "Please enter valid Phone number",
}
```

## Project Structure

- User: Entity class representing a Employee profile.
- UserRepository: Repository interface for CRUD operations on Employee profiles.
- UserController: REST controller for handling Employee-related requests.
- GlobalExceptionHandler: Global exception handler for validation errors.
- IdNotFoundException: It will handle the exception that occurs when the requested data is not available in the database, and the user attempts to fetch it.

