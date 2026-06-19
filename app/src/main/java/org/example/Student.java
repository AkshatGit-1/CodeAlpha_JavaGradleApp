package org.example;
 
public class Student {


    private int id;      
    private String name;     
    private int mathMarks;    
    private int scienceMarks;  
    private int englishMarks;  
    private int totalMarks;    
    private double percentage; 
    private String grade; 
    private boolean passed; 

    // ── Constants ───────────────────────────────────────
    public static final int MAX_MARKS_PER_SUBJECT = 100;
    public static final int TOTAL_SUBJECTS = 3;
    public static final int MAX_TOTAL_MARKS = 300;
    public static final int PASSING_MARKS = 33; // Per subject

    // ── Constructor ─────────────────────────────────────
    /**
     * Naya student banao
     * @param id - Student ID
     * @param name - Student ka naam
     * @param mathMarks - Math marks (0-100)
     * @param scienceMarks - Science marks (0-100)
     * @param englishMarks - English marks (0-100)
     */
    public Student(int id, String name, 
                   int mathMarks, int scienceMarks, int englishMarks) {
        
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name empty nahi ho sakta!");
        }
        if (mathMarks < 0 || mathMarks > 100 ||
            scienceMarks < 0 || scienceMarks > 100 ||
            englishMarks < 0 || englishMarks > 100) {
            throw new IllegalArgumentException("Marks 0-100 ke beech hone chahiye!");
        }

        this.id = id;
        this.name = name.trim();
        this.mathMarks = mathMarks;
        this.scienceMarks = scienceMarks;
        this.englishMarks = englishMarks;

        // Automatic calculations
        calculateResults();
    }

    // ── Private Methods ─────────────────────────────────

    private void calculateResults() {
        // Total marks calculate karo
        this.totalMarks = mathMarks + scienceMarks + englishMarks;

 
        this.percentage = (totalMarks * 100.0) / MAX_TOTAL_MARKS;

 
        this.passed = (mathMarks >= PASSING_MARKS) &&
                      (scienceMarks >= PASSING_MARKS) &&
                      (englishMarks >= PASSING_MARKS);
 
        this.grade = calculateGrade();
    }

 
    private String calculateGrade() {
        if (!passed) return "F"; // Fail hua toh F
        
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }

    // ── Getters ─────────────────────────────────────────
 

    public int getId()            { return id; }
    public String getName()       { return name; }
    public int getMathMarks()     { return mathMarks; }
    public int getScienceMarks()  { return scienceMarks; }
    public int getEnglishMarks()  { return englishMarks; }
    public int getTotalMarks()    { return totalMarks; }
    public double getPercentage() { return percentage; }
    public String getGrade()      { return grade; }
    public boolean isPassed()     { return passed; }


    @Override
    public String toString() {
        return String.format(
            "Student{ID=%d, Name='%s', Math=%d, Science=%d, " +
            "English=%d, Total=%d, Percentage=%.2f%%, Grade=%s, Status=%s}",
            id, name, mathMarks, scienceMarks, englishMarks,
            totalMarks, percentage, grade,
            passed ? "PASS ✓" : "FAIL ✗"
        );
    }
}