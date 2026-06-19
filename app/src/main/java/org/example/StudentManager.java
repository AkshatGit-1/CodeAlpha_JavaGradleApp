package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentManager {

    // ── Instance Variables ──────────────────────────────
    private List<Student> students; 
    private int nextId;        

    // ── Constructor ─────────────────────────────────────
    public StudentManager() {
        this.students = new ArrayList<>();
        this.nextId = 1; 
    }

    // ── Add Student ─────────────────────────────────────
    public Student addStudent(String name, 
                               int mathMarks, 
                               int scienceMarks, 
                               int englishMarks) {
        

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                throw new IllegalArgumentException(
                    "Student '" + name + "' already exists!"
                );
            }
        }

        Student newStudent = new Student(
            nextId++, name, mathMarks, scienceMarks, englishMarks
        );
        students.add(newStudent);
        
        System.out.println("✅ Student added: " + newStudent.getName() + 
                          " (ID: " + newStudent.getId() + ")");
        return newStudent;
    }

    // ── Get All Students ────────────────────────────────
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Copy return karo
    }

    // ── Get Student by ID ───────────────────────────────
    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    // ── Get Passed Students ─────────────────────────────
    public List<Student> getPassedStudents() {
        List<Student> passed = new ArrayList<>();
        for (Student s : students) {
            if (s.isPassed()) {
                passed.add(s);
            }
        }
        return passed;
    }

    // ── Get Failed Students ─────────────────────────────
    public List<Student> getFailedStudents() {
        List<Student> failed = new ArrayList<>();
        for (Student s : students) {
            if (!s.isPassed()) {
                failed.add(s);
            }
        }
        return failed;
    }

    // ── Get Topper ──────────────────────────────────────
    public Optional<Student> getTopper() {
        return students.stream()
                .max(Comparator.comparingInt(Student::getTotalMarks));
    }

    // ── Get Class Average ───────────────────────────────
    public double getClassAverage() {
        if (students.isEmpty()) return 0.0;
        
        double total = 0;
        for (Student s : students) {
            total += s.getPercentage();
        }
        return total / students.size();
    }

    // ── Get Students by Grade ───────────────────────────

    public List<Student> getStudentsByGrade(String grade) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getGrade().equalsIgnoreCase(grade)) {
                result.add(s);
            }
        }
        return result;
    }

    // ── Get Total Students Count ────────────────────────
    public int getTotalStudentsCount() {
        return students.size();
    }

    // ── Get Subject Average ─────────────────────────────
    public double getSubjectAverage(String subject) {
        if (students.isEmpty()) return 0.0;
        
        double total = 0;
        for (Student s : students) {
            switch (subject.toLowerCase()) {
                case "math":    total += s.getMathMarks();    break;
                case "science": total += s.getScienceMarks(); break;
                case "english": total += s.getEnglishMarks(); break;
                default: throw new IllegalArgumentException(
                    "Invalid subject: " + subject
                );
            }
        }
        return total / students.size();
    }
}