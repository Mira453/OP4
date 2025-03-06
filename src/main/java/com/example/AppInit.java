package com.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashSet;
import java.util.Set;


public class AppInit implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();
        Student student1 = new Student("Іван", "Москаленко", 0.0, "12321122");
        Student student2 = new Student("Назар", "Майгун", 55.5, "19345677");
        Student student3 = new Student("Руслан", "Федчук", 85.0, "1944444");

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        context.setAttribute("studentsList", students);
    }
}