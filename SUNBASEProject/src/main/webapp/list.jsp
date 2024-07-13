<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.sunbase.Model.Student, com.sunbase.DAO.StudentDAO, com.sunbase.DAOImplementation.StudentDAOImp" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <a href="add.jsp">Add New Student</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                StudentDAO studentDAO = new StudentDAOImp();
                List<Student> students = studentDAO.getAllStudents();
                for (Student student : students) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getAge() %></td>
                <td>
                    <a href="update.jsp?id=<%= student.getId() %>">Edit</a>
                    <a href="delete?id=<%= student.getId() %>">Delete</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
