package com.sunbase.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbase.DAO.StudentDAO;
import com.sunbase.DAOImplementation.StudentDAOImp;
import com.sunbase.Model.Student;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/list")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO; 
    
    public ReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	studentDAO=new StudentDAOImp();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = studentDAO.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
