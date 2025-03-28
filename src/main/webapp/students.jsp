<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Список студентів</title>
</head>
<body>
    <h2>Список студентів</h2>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <c:if test="${not empty students}">
        <table border="1">
            <tr>
                <th>Ім'я</th>
                <th>Прізвище</th>
                <th>Середній бал</th>
                <th>ID</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.averageGrade}</td>
                    <td>${student.id}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h3>Загальна кількість студентів: ${studentCount}</h3>
    <h3>Факультет з найбільшою кількістю студентів: ${largestFaculty}</h3>

    <h3>Студенти із середнім балом 95-100:</h3>
    <c:if test="${empty topStudents}">
        <p>Немає таких студентів.</p>
    </c:if>
    <c:if test="${not empty topStudents}">
        <table border="1">
            <tr>
                <th>Ім'я</th>
                <th>Прізвище</th>
                <th>Середній бал</th>
            </tr>
            <c:forEach var="student" items="${topStudents}">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.averageGrade}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
