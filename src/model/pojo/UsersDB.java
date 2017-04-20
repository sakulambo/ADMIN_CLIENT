
package model.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author joshuaOrellana
 */
public class UsersDB {
    
    private static Connection conn = null;
  
    private String _url = "jdbc:sqlserver://localhost:1433;databaseName=Users";
    private String _user = "root";
    private String _pass = "root";
    
    
    public UsersDB() {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error al registrar el driver");
            System.exit(0);
        }
        
        try {
            conn = DriverManager.getConnection(_url, _user, _pass);
        } catch (SQLException sqlE) {
            System.err.println(sqlE);
            System.exit(0);
        }
        
        if (conn != null) {
            System.out.println("Connected!");
        }
    }
    
    public Connection getConn() {
        return conn;
    }
    
    
    
}
