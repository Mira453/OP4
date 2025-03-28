package ua.example;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;


public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Institute institute = (Institute) context.getAttribute("institute"); // Отримуємо інститут з контексту
        Set<Student> students = (Set<Student>) context.getAttribute("studentsList");

        if (students == null) {
            request.setAttribute("message", "Список студентів пустий");
        } else {
            // Отримуємо факультети з інституту
            Set<Faculty> faculties = institute.getFaculties();

            // Визначити факультет з найбільшою кількістю студентів
            Faculty largestFaculty = findFacultyWithMostStudents(faculties);

            // Знайти студентів з середнім балом 95-100
            Set<Student> topStudents = getTopStudents(students);

            request.setAttribute("students", students);
            request.setAttribute("studentCount", students.size());
            request.setAttribute("largestFaculty", largestFaculty != null ? largestFaculty.getName() : "Немає факультетів");
            request.setAttribute("topStudents", topStudents);
        }

        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }

    // Метод для знаходження факультету з найбільшою кількістю студентів
    private Faculty findFacultyWithMostStudents(Set<Faculty> faculties) {
        int maxStudentsCount = 0;
        Faculty largestFaculty = null;

        for (Faculty faculty : faculties) {
            if (faculty.getStudents().size() > maxStudentsCount) {
                maxStudentsCount = faculty.getStudents().size();
                largestFaculty = faculty;
            }
        }
        return largestFaculty;
    }

    // Метод для отримання студентів з середнім балом 95-100
    private Set<Student> getTopStudents(Set<Student> students) {
        Set<Student> topStudents = new HashSet<>();
        for (Student student : students) {
            if (student.getAverageGrade() >= 95 && student.getAverageGrade() <= 100) {
                topStudents.add(student);
            }
        }
        return topStudents;
    }
}

