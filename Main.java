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
    }
}
