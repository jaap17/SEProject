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
public class Deptmemberregister  {
  public boolean check(String username,String pass)
  {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
            PreparedStatement pstmt = conn.prepareStatement("Select MemName from DeptMembers where MemberId=? and Password=?");
            pstmt.setString(1,username);
            pstmt.setString(2,pass);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
  }    
       
    
}
