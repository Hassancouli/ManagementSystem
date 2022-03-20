package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MAIN {
    static Connection con;
    static ResultSet rs;
    static PreparedStatement prst;
    static Statement st;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanovia final", "root", "");
            System.out.println("Connected");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Connection failed : \n"+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Connection failed : \n"+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public static ResultSet executeSQLQuery(String query) {
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        return rs;
    }

    public static PreparedStatement executeDynamicSQLQuery(String query) {
        try {
            prst = getConnection().prepareStatement(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return prst;
    }

    public static void closeConnection() throws SQLException {
        con.close();
        rs.close();
    }
}
