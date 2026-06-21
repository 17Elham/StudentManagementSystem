package studentmanagementsystem;
/**
 * Represents the enrollment of a student in a specific course.
 * Manages the relationship between Student and Course entities.
 * @author Elham Husein
 */
public class Enrollment {
    private Student student;
    private Course course;
    private double grade;

    // Constructor
    public Enrollment(Student student, Course course, double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    // Getters and Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Method to display enrollment details
    public void displayEnrollmentInfo() {
        System.out.println("--- Enrollment Details ---");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Enrolled in Course: " + course.getCourseName());
        System.out.println("Final Grade: " + grade);
    }
}