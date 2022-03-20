/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Classes.MAIN;
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
        String query = "SELECT * from user where user_id = 2";
        try {
            ResultSet rs = MAIN.executeDynamicSQLQuery(query).executeQuery();
            if(rs.next()) {
                System.out.println(rs.getString("username")); 
                System.out.println(rs.getString("Usertype")); 

            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
