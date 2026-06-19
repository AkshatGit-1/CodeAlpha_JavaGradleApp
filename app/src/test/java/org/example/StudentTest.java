package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student Class Tests")
public class StudentTest {

    // ── Test 1: Student Creation ─────────────────────────
    @Test
    @DisplayName("Student successfully banta hai sahi data se")
    void testStudentCreation() {
        Student student = new Student(1, "Rahul", 80, 75, 90);
        
        assertEquals(1, student.getId());
        assertEquals("Rahul", student.getName());
        assertEquals(80, student.getMathMarks());
        assertEquals(75, student.getScienceMarks());
        assertEquals(90, student.getEnglishMarks());
    }

    // ── Test 2: Total Marks Calculation ─────────────────
    @Test
    @DisplayName("Total marks sahi calculate hote hain")
    void testTotalMarksCalculation() {
        Student student = new Student(1, "Priya", 80, 75, 90);
        
        // 80 + 75 + 90 = 245
        assertEquals(245, student.getTotalMarks());
    }

    // ── Test 3: Percentage Calculation ──────────────────
    @Test
    @DisplayName("Percentage sahi calculate hoti hai")
    void testPercentageCalculation() {
        Student student = new Student(1, "Amit", 90, 90, 90);
        
        // (270/300) * 100 = 90.0%
        assertEquals(90.0, student.getPercentage(), 0.01);
    }

    // ── Test 4: Pass Status ──────────────────────────────
    @Test
    @DisplayName("Pass student sahi identify hota hai")
    void testPassStatus() {
        Student passStudent = new Student(1, "Neha", 60, 70, 80);
        assertTrue(passStudent.isPassed());
    }

    // ── Test 5: Fail Status ──────────────────────────────
    @Test
    @DisplayName("Fail student sahi identify hota hai")
    void testFailStatus() {
        // 30 marks = fail (passing = 33)
        Student failStudent = new Student(2, "Rohit", 30, 70, 80);
        assertFalse(failStudent.isPassed());
    }

    // ── Test 6: Grade A+ ────────────────────────────────
    @Test
    @DisplayName("A+ grade 90%+ pe milti hai")
    void testGradeAPlus() {
        Student student = new Student(1, "Topper", 95, 95, 95);
        assertEquals("A+", student.getGrade());
    }

    // ── Test 7: Grade F (Fail) ───────────────────────────
    @Test
    @DisplayName("Fail student ko F grade milti hai")
    void testGradeFForFail() {
        Student student = new Student(1, "Failed", 20, 70, 80);
        assertEquals("F", student.getGrade());
    }

    // ── Test 8: Invalid Marks ────────────────────────────
    @Test
    @DisplayName("101 marks dene pe exception aata hai")
    void testInvalidMarksThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student(1, "Invalid", 101, 70, 80);
        });
    }

    // ── Test 9: Negative Marks ───────────────────────────
    @Test
    @DisplayName("Negative marks pe exception aata hai")
    void testNegativeMarksThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student(1, "Invalid", -10, 70, 80);
        });
    }

    // ── Test 10: Empty Name ──────────────────────────────
    @Test
    @DisplayName("Empty name pe exception aata hai")
    void testEmptyNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student(1, "", 70, 70, 80);
        });
    }
}