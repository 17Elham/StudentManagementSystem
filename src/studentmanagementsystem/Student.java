package studentmanagementsystem;

public class Student extends Person {
    private double gpa;
    private String major;

    public Student(int id, String name, String email, double gpa, String major) {
        super(id, name, email);
        this.gpa = gpa;
        this.major = major;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        if(gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: GPA must be between 0.0 and 4.0");
        }
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Student Details ===");
        System.out.println("ID: " + getId()); 
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
    }
}
