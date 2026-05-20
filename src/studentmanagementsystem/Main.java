package studentmanagementsystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Management System - Test Run ===\n");

        try {
            // 1. Testing Teacher Class (Matching your specific 5-parameter constructor)
            Teacher teacher = new Teacher(101, "Dr. Ahmed", "ahmed@university.com", "Computer Science", 2500.0);
            teacher.displayDetails();
            System.out.println("------------------------------------");

            // 2. Testing Department Class
            Department dept = new Department("Software Engineering");
            dept.addCourse("Advanced OOP");
            dept.addCourse("Database Systems");
            dept.addCourse("Software Architecture");
            dept.displayDepartmentInfo();
            System.out.println("------------------------------------");

            // 3. Testing Student Class
            Student student = new Student(2021, "Elham", "elham@student.com", 3.75, "Software Engineering");
            student.displayDetails();
            System.out.println("------------------------------------");

            // 4. Testing Exception Handling (Age validation check)
            int testAge = -5; 
            if (testAge < 0) {
                throw new IllegalArgumentException("Age cannot be negative!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Alert/Exception Caught: " + e.getMessage());
        }
        
        System.out.println("\nSystem continues running smoothly...");
    }
}