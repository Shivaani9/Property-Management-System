/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.xemacscode.demo;
import java.sql.*;
import static java.util.jar.Pack200.Packer.PASS;
import static javafx.css.StyleOrigin.USER;
/**
 *
 * @author Malanchite
 */
public class DBConnection {
   
    static final String DB_URL = "jdbc:mysql://localhost/demo";
    static final String USER="root";
    static final String PASS="";
    public static Connection connectDB(){
         Connection conn = null;
        try{
           // Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        }catch(Exception ex){
            System.out.println("There were errors while connecting to db");
            return null;
        }
    }

    static Object getTheConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
