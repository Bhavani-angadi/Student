<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.sunbase.Model.Student, com.sunbase.DAO.StudentDAO, com.sunbase.DAOImplementation.StudentDAOImp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h2>Update Student</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO studentDAO = new StudentDAOImp();
        Student student = studentDAO.getStudent(id);

        if (request.getMethod().equalsIgnoreCase("post")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            
            student.setName(name);
            student.setEmail(email);
            student.setAge(age);
            
            studentDAO.updateStudent(student);
            response.sendRedirect("list");
        }
    %>
    <form action="update.jsp?id=<%= student.getId() %>" >
        <input type="hidden" name="id" value="<%= student.getId() %>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= student.getName() %>"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="<%= student.getEmail() %>"><br>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" value="<%= student.getAge() %>"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>