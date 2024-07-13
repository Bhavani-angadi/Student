package com.sunbase.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbase.DAO.StudentDAO;
import com.sunbase.Model.Student;

public class StudentDAOImp implements StudentDAO{

	Connection connection;
	
	public StudentDAOImp() {
		
		
		String url="jdbc:mysql://localhost:3306/sunbase";
		String userName="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addStudent(Student student) {
		try  {
            String sql = "INSERT INTO student (name, email, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Student getStudent(int id) {
		Student student = null;
        try  {
            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
        try  {
            String sql = "SELECT * FROM student";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
	}

	@Override
	public void updateStudent(Student student) {
		try  {
            String sql = "UPDATE student SET name = ?, email = ?, age = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteStudent(int id) {
		try  {
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
