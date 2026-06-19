package org.example;

public class App {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   CODEALPHA INTERNSHIP - TASK 3        ║");
        System.out.println("║   Student Management System            ║");
        System.out.println("║   Built with Gradle 🔨                 ║");
        System.out.println("╚════════════════════════════════════════╝");

        //Setup
        StudentManager manager       = new StudentManager();
        ResultGenerator resultGen    = new ResultGenerator(manager);

        System.out.println("\n📝 Adding students to the system...\n");

        // Add Students
        // Format: Name, Math, Science, English
        manager.addStudent("Rahul Sharma",   85, 78, 92);
        manager.addStudent("Priya Singh",    92, 95, 88);
        manager.addStudent("Amit Kumar",     45, 38, 50);
        manager.addStudent("Neha Gupta",     78, 82, 75);
        manager.addStudent("Rohit Verma",    30, 25, 28);
        manager.addStudent("Anjali Mehta",   95, 98, 97);
        manager.addStudent("Vikram Joshi",   60, 65, 58);
        manager.addStudent("Sunita Patel",   55, 48, 62);

        // ── Print Results ───────────────────────────────
        resultGen.printAllResults();

        // 2. Class summary
        resultGen.printClassSummary();

        // 3. Topper announcement
        resultGen.printTopper();

        // 4. Individual report card
        System.out.println("\n📄 Individual Report Card Example:");
        resultGen.printStudentResult(6); // Anjali ka card

        // 5. Pass/Fail lists
        System.out.println("\n✅ PASSED STUDENTS:");
        for (Student s : manager.getPassedStudents()) {
            System.out.println("   → " + s.getName() + 
                             " (" + s.getGrade() + " - " + 
                             String.format("%.1f", s.getPercentage()) + "%)");
        }

        System.out.println("\n❌ FAILED STUDENTS:");
        for (Student s : manager.getFailedStudents()) {
            System.out.println("   → " + s.getName() + 
                             " (Percentage: " + 
                             String.format("%.1f", s.getPercentage()) + "%)");
        }

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   System Run Successfully! ✅           ║");
        System.out.println("║   CodeAlpha DevOps Internship          ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}