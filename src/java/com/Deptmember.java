/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.sql.*;
/**
 *
 * @author JAAP B ANJARIA
 */
public class Deptmember {
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(" insert into deptpass values('F014','F014') ");
            stmt.close();
            conn.close();
            // ResultSet rs = pstmt.executeQuery();
    }
    
}
