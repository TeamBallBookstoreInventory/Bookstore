import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class DBConnection {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore_inventory";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jbdc.Driver");
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Succesfull.");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error connecting to the database." + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("MySQL JDBC Driver not found." + e.getMessage());
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        if (connection != null) {
        try{
            connection.close();
            System.out.println("Connection Closed.");
        }catch (SQLException e){
            System.out.println("Error closing the connection." + e.getMessage());
        }
    }
    } 
    
}
