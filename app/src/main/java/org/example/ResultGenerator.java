package org.example;

import java.util.List;
import java.util.Optional;

public class ResultGenerator {

    private StudentManager manager;

    // ── Constructor ─────────────────────────────────────
    public ResultGenerator(StudentManager manager) {
        this.manager = manager;
    }

    public void printAllResults() {
        List<Student> students = manager.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("❌ No Student Found!");
            return;
        }

        printHeader("📋 COMPLETE RESULT SHEET");
        printTableHeader();
        printDivider();

        for (Student s : students) {
            printStudentRow(s);
        }

        printDivider();
        printFooter();
    }

    public void printStudentResult(int studentId) {
        Optional<Student> found = manager.getStudentById(studentId);
        
        if (!found.isPresent()) {
            System.out.println("❌ ID " + studentId + " ka student nahi mila!");
            return;
        }

        Student s = found.get();
        
        printHeader("📄 STUDENT REPORT CARD");
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf("│  Student ID  : %-21d│%n", s.getId());
        System.out.printf("│  Name        : %-21s│%n", s.getName());
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│  Math        : %-21d│%n", s.getMathMarks());
        System.out.printf("│  Science     : %-21d│%n", s.getScienceMarks());
        System.out.printf("│  English     : %-21d│%n", s.getEnglishMarks());
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│  Total       : %-21d│%n", s.getTotalMarks());
        System.out.printf("│  Percentage  : %-20.2f%%│%n", s.getPercentage());
        System.out.printf("│  Grade       : %-21s│%n", s.getGrade());
        System.out.printf("│  Status      : %-21s│%n", 
                          s.isPassed() ? "✅ PASS" : "❌ FAIL");
        System.out.println("└─────────────────────────────────────┘");
    }

    public void printClassSummary() {
        printHeader("📊 CLASS PERFORMANCE SUMMARY");

        int total   = manager.getTotalStudentsCount();
        int passed  = manager.getPassedStudents().size();
        int failed  = manager.getFailedStudents().size();
        double avg  = manager.getClassAverage();

        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf("│  Total Students  : %-17d│%n", total);
        System.out.printf("│  Passed Students : %-17d│%n", passed);
        System.out.printf("│  Failed Students : %-17d│%n", failed);
        System.out.printf("│  Pass Percentage : %-16.1f%%│%n",
                          total > 0 ? (passed * 100.0 / total) : 0);
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│  Class Average   : %-16.2f%%│%n", avg);
        System.out.printf("│  Math Average    : %-16.2f%%│%n",
                          total > 0 ? manager.getSubjectAverage("math") : 0);
        System.out.printf("│  Science Average : %-16.2f%%│%n",
                          total > 0 ? manager.getSubjectAverage("science") : 0);
        System.out.printf("│  English Average : %-16.2f%%│%n",
                          total > 0 ? manager.getSubjectAverage("english") : 0);
        System.out.println("├─────────────────────────────────────┤");

        // Topper
        Optional<Student> topper = manager.getTopper();
        if (topper.isPresent()) {
            System.out.printf("│  🏆 Class Topper : %-17s│%n", 
                             topper.get().getName());
            System.out.printf("│  Topper Score    : %-16.2f%%│%n",
                             topper.get().getPercentage());
        }
        System.out.println("└─────────────────────────────────────┘");
    }

    // Print Topper
    public void printTopper() {
        Optional<Student> topper = manager.getTopper();
        printHeader("🏆 CLASS TOPPER");
        
        if (topper.isPresent()) {
            Student t = topper.get();
            System.out.println("🥇 Topper: " + t.getName());
            System.out.printf("   Score : %.2f%% (Grade: %s)%n",
                             t.getPercentage(), t.getGrade());
        } else {
            System.out.println("❌ Koi student registered nahi hai!");
        }
    }

    // Helper Methods
    private void printHeader(String title) {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.printf( "║  %-36s║%n", title);
        System.out.println("╚══════════════════════════════════════╝");
    }

    private void printTableHeader() {
        System.out.printf("%-5s %-15s %-6s %-8s %-8s %-7s %-7s %-6s %-6s%n",
            "ID", "Name", "Math", "Science", "English", 
            "Total", "Perc%", "Grade", "Status");
    }

    private void printStudentRow(Student s) {
        System.out.printf("%-5d %-15s %-6d %-8d %-8d %-7d %-7.1f %-6s %-6s%n",
            s.getId(), s.getName(),
            s.getMathMarks(), s.getScienceMarks(), s.getEnglishMarks(),
            s.getTotalMarks(), s.getPercentage(),
            s.getGrade(), s.isPassed() ? "PASS" : "FAIL");
    }

    private void printDivider() {
        System.out.println("─".repeat(70));
    }

    private void printFooter() {
        System.out.printf("%nClass Average: %.2f%%%n", 
                         manager.getClassAverage());
    }
}