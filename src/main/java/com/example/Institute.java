package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Institute {
    private final String name;
    private Set<Faculty> faculties;
    private Map<String, Student> studentMap;

    public Institute(String name, Set<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
        this.studentMap = new HashMap<>();

        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                studentMap.put(student.getId(), student);
            }
        }
    }


    public int getStudentsCount() {
        int studentsCount = 0;
        for (Faculty faculty : faculties) {
            studentsCount += faculty.getStudents().size();
        }
        return studentsCount;
    }

    public Student findStudentById(String id) {
        return studentMap.get(id);
    }
}