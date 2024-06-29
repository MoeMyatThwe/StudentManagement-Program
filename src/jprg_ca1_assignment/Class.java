
package jprg_ca1_assignment;

import java.util.ArrayList;


public class Class {
    private String className;
    private ArrayList<Student> students;

    public Class(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateClassAverageGPA() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double totalGPA = 0.0;
        for (Student student : students) {
            totalGPA += student.getGpa();
        }

        return totalGPA / students.size();
    }

    public String getClassInfo() {
        return className + " - Average GPA: " + String.format("%.2f", calculateClassAverageGPA());
    }
}
