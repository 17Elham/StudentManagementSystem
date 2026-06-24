package studentmanagementsystem;

import java.util.ArrayList;

// Department class to manage university departments
public class Department {
    private String deptName;
    private ArrayList<String> coursesList;

    // Constructor
    public Department(String deptName) {
        this.deptName = deptName;
        this.coursesList = new ArrayList<>();
    }

    // Encapsulation: Getters and Setters
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Method to add a course to the department
    public void addCourse(String courseName) {
        coursesList.add(courseName);
    }

    // Method to display department details
    public void displayDepartmentInfo() {
        System.out.println("Department Name: " + deptName);
        System.out.println("Courses Offered: " + coursesList);
    }
}