# Courses API Backend

## Overview
The Courses API Backend project is a RESTful API designed for managing course information. Developed using Spring Boot and MySQL, this project aims to provide a robust backend solution for CRUD operations on course data.

## Methodology
- Planning: The project was designed to handle course data with full CRUD (Create, Read, Update, Delete) operations. The API endpoints were planned to interact with a MySQL database.
- Implementation: The backend was implemented using Spring Boot, with JPA (Java Persistence API) for database interactions. The H2 in-memory database was initially used for development and testing.
- Testing: The endpoints were tested using Postman to ensure that all CRUD operations function correctly. Testing was performed to validate the correct implementation of API endpoints.

## Software and Tools Used
- Programming Languages: Java
- Frameworks: Spring Boot
- Database: MySQL
- IDE: Apache NetBeans, Visual Studio Code
- Other Tools: Git, Maven, Postman

## Usage

Create a Course:

Method: POST
Endpoint: /api/courses
Request Body: { "title": "Course Title", "description": "Course Description" }

Get All Courses:

Method: GET
Endpoint: /api/courses

Get Course by ID:

Method: GET
Endpoint: /api/courses/{id}

Update a Course:

Method: PUT

Endpoint: /api/courses/{id}
Request Body: { "title": "Updated Title", "description": "Updated Description" }

Delete a Course:

Method: DELETE
Endpoint: /api/courses/{id}

## Future Work
Add user authentication to secure API endpoints.
Implement additional features such as course search and filtering.