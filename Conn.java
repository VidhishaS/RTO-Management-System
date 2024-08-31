
package rmanagement;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///rto", "root", "Vidhisha0530");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}