package studentmanagementsystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Management System - Test Run ===\n");

        // 1. صُنع الكائنات برّع الـ try عشان يقعدوا حقيقيين ونقدروا نربطوهم ببعض لوطة
        Student student = null;
        Course course = null;
        Teacher teacher = null;
        Department dept = null;

        try {
            // 2. إنشاء كلاس القسم
            dept = new Department("Software Engineering");

            // 3. إنشاء كلاس المدرس وإضافته للقسم
            teacher = new Teacher(101, "Dr. Ahmed", "ahmed@university.com", "Computer Science", 2500.0);
            System.out.println("=== Testing Teacher Class ===");
            teacher.displayDetails();
            System.out.println("-----------------------------------");

            // 4. إنشاء كلاس المادة
            System.out.println("\n=== Testing Course Class ===");
            course = new Course("CS211", "Object-Oriented Programming", 3);
            course.displayCourseInfo();
            System.out.println("-----------------------------------");

            // 5. إنشاء كلاس الطالب (هذا هو الطالب الحقيقي اللي حنربطوه)
            student = new Student(2021, "Elham", "elham@student.com", 3.75, "Software Engineering");
            System.out.println("\n=== Testing Student Class ===");
            student.displayDetails();
            System.out.println("-----------------------------------");

            // 6. الربط الحقيقي والفعّال (كلاس الـ Enrollment يربط الطالب بالمادة)
            System.out.println("\n=== Testing Enrollment Class ===");
            if (student != null && course != null) {
                Enrollment enrollment = new Enrollment(student, course, 95.5);
                enrollment.displayEnrollmentInfo();
            }
            System.out.println("-----------------------------------");

            // 7. تجربة الـ Exception Handling (شغل الحماية اللي يبيها الدكتور)
            System.out.println("\n=== Testing Exception Handling (Age validation check) ===");
            int testAge = -5;
            if (testAge < 0) {
                throw new IllegalArgumentException("Age cannot be negative!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Alert/Exception Caught: " + e.getMessage());
        }

        System.out.println("\nSystem continues running smoothly...");
        
        
        // Fetch and display student enrollment report from database
        System.out.println("\n=== Student Enrollment Report (From Database) ===");
        String query = "SELECT s.name AS student_name, c.course_name AS course_name, e.grade AS final_grade " +
                       "FROM enrollments e " +
                       "INNER JOIN students s ON e.student_id = s.student_id " +
                       "INNER JOIN courses c ON e.course_code = c.course_code";

        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            System.out.println(String.format("%-15s | %-30s | %-10s", "Student Name", "Course Name", "Grade"));
            System.out.println("------------------------------------------------------------------");

            while (rs.next()) {
                String studentName = rs.getString("student_name");
                String courseName = rs.getString("course_name");
                double grade = rs.getDouble("final_grade");
                
                System.out.println(String.format("%-15s | %-30s | %-10.1f", studentName, courseName, grade));
            }
            System.out.println("------------------------------------------------------------------");

        } catch (java.sql.SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
        }
    }
