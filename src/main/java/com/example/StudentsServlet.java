package com.example;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;


public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Set<Student> students = (Set<Student>) context.getAttribute("studentsList");

        if (students == null) {
            request.setAttribute("message", "Список студентів пустий");
        } else {
            request.setAttribute("students", students);
        }

        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}