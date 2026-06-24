package studentmanagementsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Represents a student entity in the system.
 * Inherits common attributes from the Person class.
 * @author Elham Husein
 * @version 1.0
 */
public class Student extends Person implements DatabaseOperations {
    private double gpa;
    private String major;

    public Student(int id, String name, String email, double gpa, String major) {
        super(id, name, email); //      
        this.gpa = gpa;
        this.major = major;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
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

    @Override
    public void save() {
    try {
        // افترضي أن لديكِ اتصال جاهز بقاعدة البيانات
        Connection conn = DatabaseConnection.getConnection(); 
        String query = "INSERT INTO students (id, name, email, major, gpa) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, this.getId()); // نفترض وجود دالة getId() من Person
        pstmt.setString(2, this.getName());
        pstmt.setString(3, this.getEmail());
        pstmt.setString(4, this.major);
        pstmt.setDouble(5, this.gpa);
        
        pstmt.executeUpdate();
        System.out.println("تم حفظ الطالب في قاعدة البيانات بنجاح!");
        
    } catch (SQLException e) {
        System.out.println("حدث خطأ أثناء الحفظ: " + e.getMessage());
    }
}
    

    @Override
    public void delete() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, this.getId());
        
        pstmt.executeUpdate();
        System.out.println("تم حذف الطالب من قاعدة البيانات بنجاح!");
        
    } catch (SQLException e) {
        System.out.println("حدث خطأ أثناء الحذف: " + e.getMessage());
    }
}

    

    @Override
    public void update() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE students SET name = ?, email = ?, major = ?, gpa = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, this.getName());
        pstmt.setString(2, this.getEmail());
        pstmt.setString(3, this.major);
        pstmt.setDouble(4, this.gpa);
        pstmt.setInt(5, this.getId());
        
        pstmt.executeUpdate();
        System.out.println("تم تحديث بيانات الطالب بنجاح!");
        
    } catch (SQLException e) {
        System.out.println("حدث خطأ أثناء التحديث: " + e.getMessage());
    }


    }
}