/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;
import java.sql.*;
/**
 *
 * @author JAAP B ANJARIA
 */
public class CourseListDesign {
      public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
          try
          {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(" create table CourseList( CourseId varchar(10) , CourseName varchar(20) , Semester Integer(2) ,PRIMARY KEY(CourseId,CourseName) , FOREIGN KEY(CourseId) REFERENCES DeptCourses(CourseId)  ); ");
            stmt.close();
            conn.close();
          }catch(Exception e)
          {
              System.out.println(e);
          }
    }
}
