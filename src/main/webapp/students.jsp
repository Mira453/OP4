<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.Student" %>
<html>
<body>
    <h2>Список студентів:</h2>
    <ul>
 <%
           Set<Student> students = (Set<Student>) request.getAttribute("students");
               for (Student student : students) {
                   out.println("<li>" + student.getFirstName() + " " + student.getLastName()+  "</li>");
               }
       %>
    </ul>
</body>
</html>