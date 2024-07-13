package com.sunbase.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbase.DAO.StudentDAO;
import com.sunbase.DAOImplementation.StudentDAOImp;
import com.sunbase.Model.Student;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;   
  
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	studentDAO = new StudentDAOImp();
    }
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);

        studentDAO.updateStudent(student);
        response.sendRedirect("list");
	}

}
