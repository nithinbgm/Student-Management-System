# Student Management System

A simple Student Management System built using Java and MySQL. This application allows users to perform basic CRUD operations (Create, Read, Update, Delete) for managing student data.

## Features
- **Add Student**: Add a new student to the system with ID, name, age, and course.
- **View Students**: Display a list of all students in the system.
- **Update Student**: Update the details (name, age, course) of an existing student.
- **Delete Student**: Remove a student from the system.

## Technologies Used
- **Java**: Programming language for building the application.
- **MySQL**: Database used to store student data.
- **JDBC**: Java Database Connectivity to connect and interact with MySQL database.

## Installation

1. Clone this repository:
   git clone https://github.com/yourusername/StudentManagementSystem.git
2. Set up the database:

Create a MySQL database named student_management.
Import the necessary schema into MySQL.
Example SQL:
CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(50)
);
3. Configure the database connection in the code:

Edit the DBConnection.java file to match your MySQL username, password, and database details.
Run the application using your favorite IDE or via command line.


Here's a simple README.md file for your Student Management System project:

markdown
Copy code
# Student Management System

A simple Student Management System built using Java and MySQL. This application allows users to perform basic CRUD operations (Create, Read, Update, Delete) for managing student data.

## Features
- **Add Student**: Add a new student to the system with ID, name, age, and course.
- **View Students**: Display a list of all students in the system.
- **Update Student**: Update the details (name, age, course) of an existing student.
- **Delete Student**: Remove a student from the system.

## Technologies Used
- **Java**: Programming language for building the application.
- **MySQL**: Database used to store student data.
- **JDBC**: Java Database Connectivity to connect and interact with MySQL database.

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/StudentManagementSystem.git
Set up the database:

Create a MySQL database named student_management.
Import the necessary schema into MySQL.
Example SQL:

sql
Copy code
CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(50)
);
Configure the database connection in the code:

Edit the DBConnection.java file to match your MySQL username, password, and database details.
Run the application using your favorite IDE or via command line.

Usage
Run the application.
Choose an option from the menu:
1 to Add a Student
2 to View All Students
3 to Update a Student's Information
4 to Delete a Student
5 to Exit the application
