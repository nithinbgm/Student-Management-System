package org.studentmanagement.dao;

        import org.studentmanagement.model.Student;
        import org.studentmanagement.util.DBConnection;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

public class StudentDAO {
    // Add a student
    public void addStudent(Student student) {
        String query = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getCourse());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("course")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }


    //update a student by ID
    public void updateStudent(int id, String name, int age, String course) {
        String query = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, course);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student with ID " + id + " updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String course = resultSet.getString("course");

                return new Student(studentId, name, age, course);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        return null;
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
