package studentmanagementsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Represents a teacher entity in the system.
 * Inherits common attributes from the Person class and adds
 * information related to the teacher's department.
 * @author Elham Husein
 * @version 1.0
 */
public class Teacher extends Person implements DatabaseOperations {
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

    @Override
    public void save() {
    try {
        Connection conn = DatabaseConnection.getConnection();
        // لاحظي أن الجدول هنا اسمه teachers (أو حسب ما هو موجود في قاعدة بياناتك)
        String query = "INSERT INTO teachers (id, name, email, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, this.getId());
        pstmt.setString(2, this.getName());
        pstmt.setString(3, this.getEmail());
        // افترضي أن لديه خاصية الراتب
        pstmt.setDouble(4, this.getSalary()); 
        
        pstmt.executeUpdate();
        System.out.println("تم حفظ بيانات المدرس بنجاح!");
    } catch (SQLException e) {
        System.out.println("خطأ في حفظ المدرس: " + e.getMessage());
    }
}
        
    

    @Override
    public void delete() {

    try {
        // الاتصال بقاعدة البيانات
        Connection conn = DatabaseConnection.getConnection();
        
        // جملة الحذف (تأكدي من اسم الجدول teachers)
        String query = "DELETE FROM teachers WHERE id = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        // تحديد الـ ID الخاص بالمدرس المراد حذفه
        pstmt.setInt(1, this.getId());
        
        // تنفيذ عملية الحذف
        pstmt.executeUpdate();
        
        System.out.println("تم حذف المدرس بنجاح من قاعدة البيانات!");
        
    } catch (SQLException e) {
        // طباعة رسالة توضيحية في حال حدوث خطأ
        System.out.println("حدث خطأ أثناء حذف المدرس: " + e.getMessage());
    }

    }

    @Override
    public void update() {

    try {
        // الاتصال بقاعدة البيانات
        Connection conn = DatabaseConnection.getConnection();
        
        // جملة التعديل (SQL Update)
        // تأكدي أن أسماء الأعمدة في القاعدة تطابق ما كتبته هنا
        String query = "UPDATE teachers SET name = ?, email = ?, salary = ? WHERE id = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        // ربط البيانات بالاستعلام (بالترتيب)
        pstmt.setString(1, this.getName());
        pstmt.setString(2, this.getEmail());
        pstmt.setDouble(3, this.getSalary());
        pstmt.setInt(4, this.getId()); // هذا هو المعيار الذي نعرف من خلاله أي مدرس سنعدله
        
        // تنفيذ التعديل
        int rowsUpdated = pstmt.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("تم تحديث بيانات المدرس بنجاح!");
        } else {
            System.out.println("لم يتم العثور على مدرس بهذا الـ ID.");
        }
        
    } catch (SQLException e) {
        System.out.println("حدث خطأ أثناء التحديث: " + e.getMessage());
    }


    }
}