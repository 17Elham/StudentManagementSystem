package studentmanagementsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Represents a course offered by the academy.
 * Stores course name and course code.
 * @author Elham Husein
 */


public class Course implements DatabaseOperations {
    private int id;
    private String courseName;
    private String courseCode;
    private int creditHours;
    

    // Constructor
    public Course(  String courseName, String courseCode, int id) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * Overrides the displayInfo method from the Person class
     * to include student-specific details.
     */
    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credit Hours: " + creditHours);
    }

    @Override
    public void save() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // غيري اسم الجدول والأعمدة حسب الكلاس
        String query = "INSERT INTO table_name (col1, col2, col3) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, this.getCourseCode()); 
        pstmt.setString(2, this.getCourseName());
        pstmt.setInt(3, this.getCreditHours());
        
        pstmt.executeUpdate();
        System.out.println("تمت عملية الحفظ بنجاح!");
    } catch (SQLException e) {
        System.out.println("خطأ في الحفظ: " + e.getMessage());
    }

    }

    @Override
    public void delete() {

    try {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DELETE FROM courses WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        // نفترض أن id هو المتغير الذي يحمل كود المادة
        pstmt.setInt(1, this.id); 
        
        pstmt.executeUpdate();
        System.out.println("تم حذف المادة بنجاح!");
    } catch (SQLException e) {
        System.out.println("خطأ أثناء حذف المادة: " + e.getMessage());
    }
}
    

    @Override
    public void update() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // تأكدي من تطابق أسماء الأعمدة هنا مع الجدول في MySQL
        String query = "UPDATE courses SET name = ?, hours = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, this.getCourseName());
        pstmt.setInt(2, this.getCreditHours());
        pstmt.setInt(3, this.id); // الـ ID المستخدم في البحث عن المادة
        
        pstmt.executeUpdate();
        System.out.println("تم تحديث بيانات المادة بنجاح!");
    } catch (SQLException e) {
        System.out.println("خطأ أثناء تحديث المادة: " + e.getMessage());
    }
}
public static void displayAllCourses() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM courses";
        java.sql.Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        System.out.println("--- قائمة المواد الدراسية ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + 
                               " | Name: " + rs.getString("name") + 
                               " | Hours: " + rs.getInt("hours"));
        }
    } catch (SQLException e) {
        System.out.println("خطأ في جلب البيانات: " + e.getMessage());
    }
}

    }
