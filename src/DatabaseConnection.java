 package studentmanagementsystem;
/**
     * Establishes a connection to the MySQL database.
     * @return A Connection object if the connection is successful.
     * @throws SQLException If a database access error occurs.
     */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentmanagementdb";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Elham"; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return connection;
    }
}