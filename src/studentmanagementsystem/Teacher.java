package studentmanagementsystem;
/**
 * Represents a teacher entity in the system.
 * Inherits common attributes from the Person class and adds
 * information related to the teacher's department.
 * @author Elham Husein
 * @version 1.0
 */
public class Teacher extends Person {
    private String department;
    private double salary;

    public Teacher(int id, String name, String email, String department, double salary) {
        super(id, name, email); // يمرر الـ 3 متغيرات للأب بنجاح
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Teacher Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}