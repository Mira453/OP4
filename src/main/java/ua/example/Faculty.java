package ua.example;

import java.util.Set;

public class Faculty {
    private final String name;
    private static Set<Student> students;

    public Faculty(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }


    public static Set<Student> getStudents() {
        return students;
    }
}