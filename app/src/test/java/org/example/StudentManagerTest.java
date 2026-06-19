package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StudentManager Class Tests")
public class StudentManagerTest {

    private StudentManager manager;

    @BeforeEach
    void setUp() {
        manager = new StudentManager();
 
    }
    @Test
    @DisplayName("Student successfully adds up")
    void testAddStudent() {
        Student s = manager.addStudent("Rahul", 80, 75, 90);
        
        assertNotNull(s);
        assertEquals("Rahul", s.getName());
        assertEquals(1, manager.getTotalStudentsCount());
    }

    @Test
    @DisplayName("Multiple students can be added")
    void testAddMultipleStudents() {
        manager.addStudent("Rahul",  80, 75, 90);
        manager.addStudent("Priya",  90, 85, 88);
        manager.addStudent("Amit",   70, 65, 72);
        
        assertEquals(3, manager.getTotalStudentsCount());
    }

    // ── Test 3: Get By ID ────────────────────────────────
    @Test
    @DisplayName("ID se student milta hai")
    void testGetStudentById() {
        manager.addStudent("Rahul", 80, 75, 90);
        
        Optional<Student> found = manager.getStudentById(1);
        assertTrue(found.isPresent());
        assertEquals("Rahul", found.get().getName());
    }

    // ── Test 4: Wrong ID ─────────────────────────────────
    @Test
    @DisplayName("Galat ID pe empty Optional milta hai")
    void testGetStudentByWrongId() {
        Optional<Student> found = manager.getStudentById(999);
        assertFalse(found.isPresent());
    }

    // ── Test 5: Passed Students ──────────────────────────
    @Test
    @DisplayName("Pass hue students sahi milte hain")
    void testGetPassedStudents() {
        manager.addStudent("PassStudent", 60, 60, 60); // Pass
        manager.addStudent("FailStudent", 20, 60, 60); // Fail
        
        List<Student> passed = manager.getPassedStudents();
        assertEquals(1, passed.size());
        assertEquals("PassStudent", passed.get(0).getName());
    }

    // ── Test 6: Failed Students ──────────────────────────
    @Test
    @DisplayName("Fail hue students sahi milte hain")
    void testGetFailedStudents() {
        manager.addStudent("PassStudent", 60, 60, 60); // Pass
        manager.addStudent("FailStudent", 20, 60, 60); // Fail
        
        List<Student> failed = manager.getFailedStudents();
        assertEquals(1, failed.size());
        assertEquals("FailStudent", failed.get(0).getName());
    }

    // ── Test 7: Topper ───────────────────────────────────
    @Test
    @DisplayName("Topper sahi identify hota hai")
    void testGetTopper() {
        manager.addStudent("Average", 60, 60, 60); // 180 total
        manager.addStudent("Topper",  95, 95, 95); // 285 total
        manager.addStudent("Good",    75, 75, 75); // 225 total
        
        Optional<Student> topper = manager.getTopper();
        assertTrue(topper.isPresent());
        assertEquals("Topper", topper.get().getName());
    }

    // ── Test 8: Class Average ────────────────────────────
    @Test
    @DisplayName("Class average sahi calculate hota hai")
    void testClassAverage() {
        manager.addStudent("S1", 100, 100, 100); // 100%
        manager.addStudent("S2", 50,  50,  50);  // 50%
        
        // Average = (100 + 50) / 2 = 75%
        assertEquals(75.0, manager.getClassAverage(), 0.01);
    }

    // ── Test 9: Duplicate Name ───────────────────────────
    @Test
    @DisplayName("Duplicate name pe exception aata hai")
    void testDuplicateNameThrowsException() {
        manager.addStudent("Rahul", 80, 75, 90);
        
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("Rahul", 70, 65, 80);
        });
    }

    // ── Test 10: Empty Manager ───────────────────────────
    @Test
    @DisplayName("Empty manager mein 0 students hote hain")
    void testEmptyManager() {
        assertEquals(0, manager.getTotalStudentsCount());
        assertTrue(manager.getAllStudents().isEmpty());
        assertFalse(manager.getTopper().isPresent());
    }
}