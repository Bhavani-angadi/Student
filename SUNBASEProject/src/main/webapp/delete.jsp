<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.sunbase.Model.Student, com.sunbase.DAO.StudentDAO, com.sunbase.DAOImplementation.StudentDAOImp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO studentDAO = new StudentDAOImp();
        studentDAO.deleteStudent(id);
        response.sendRedirect("list");
    %>
</body>
</html>