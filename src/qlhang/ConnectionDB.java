/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhang;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDB {
   private Connection con = null;
   public Connection getConnectionDB() {
       try {
           String url = "jdbc:sqlserver://localhost:1433;databaseName=QLHANG";
           String user = "sa";
           String pass = "12345";
           Class.forName("com.microsoft.sqlserver.jdbc.SqlServerDriver");
           con = DriverManager.getConnection(url,user,pass);
           System.out.println("thành công");
       } catch (Exception e) {
           System.out.println("không kết nối được");
       }
       return con;
       
       
   }
}
