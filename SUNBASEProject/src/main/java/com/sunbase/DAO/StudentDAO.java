package com.sunbase.DAO;

import java.util.List;

import com.sunbase.Model.Student;

public interface StudentDAO {
	
	void addStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);

}
