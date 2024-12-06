package org.studentmanagement.main;

        import org.studentmanagement.dao.StudentDAO;
        import org.studentmanagement.model.Student;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    studentDAO.addStudent(new Student(id, name, age, course));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    studentDAO.getAllStudents().forEach(System.out::println);
                    break;
                case 3: // Update Student
                    System.out.println("Enter the ID of the student you want to update:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    // Fetch student details from the database (show current info if needed)
                    Student studentToUpdate = studentDAO.getStudentById(updateId);
                    if (studentToUpdate == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    // Show current details
                    System.out.println("Current Details: " + studentToUpdate);

                    // Ask for new data
                    System.out.println("Enter new name (leave blank to keep unchanged):");
                    String newName = scanner.nextLine();
                    if (newName.isEmpty()) {
                        newName = studentToUpdate.getName();
                    }

                    System.out.println("Enter new age (leave blank to keep unchanged):");
                    String newAgeInput = scanner.nextLine();
                    int newAge = studentToUpdate.getAge(); // default to current age
                    if (!newAgeInput.isEmpty()) {
                        newAge = Integer.parseInt(newAgeInput);
                    }

                    System.out.println("Enter new course (leave blank to keep unchanged):");
                    String newCourse = scanner.nextLine();
                    if (newCourse.isEmpty()) {
                        newCourse = studentToUpdate.getCourse();
                    }

                    // Update the student in the database
                    studentDAO.updateStudent(updateId, newName, newAge, newCourse);
                    System.out.println("Student updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentDAO.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}
