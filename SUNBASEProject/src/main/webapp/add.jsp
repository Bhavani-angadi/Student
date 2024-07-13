<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.sunbase.Model.Student, com.sunbase.DAO.StudentDAO, com.sunbase.DAOImplementation.StudentDAOImp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h2>Add New Student</h2>
    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);
            student.setAge(age);
            
            StudentDAO studentDAO = new StudentDAOImp();
            studentDAO.addStudent(student);
            response.sendRedirect("list");
        }
    %>
    <form action="create" >
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age"><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>