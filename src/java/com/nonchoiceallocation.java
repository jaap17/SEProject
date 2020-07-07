/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author JAAP B ANJARIA
 */
public class nonchoiceallocation extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root", "");
            String sql = "Select * from nonselectedfaculties";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            try(PrintWriter out = response.getWriter())
            {
                
                out.println("<html>");
                out.println("<head>");
                out.println("<link href='test.css' rel='stylesheet'>");
                out.println("<link href='test1.css' rel='stylesheet'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>");
                out.println("<ul>");
                out.println("<li style='float:right'>");
                out.println("<form action='TaskSelection' method='POST'>");
                out.println("<input type='submit' value='Homepage'>");
                out.println("</form>");
                
                out.println("</li>");
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("<hr>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td> <font size='7'><b><i> MemberName </i></b></font></td>");
                out.println("<td> <font size='7'><b><i> Allocated Subject </i></b></font></td>");
                out.println("</tr>");
                while(rs.next())
                {
                    String memname = rs.getString("MemberName");
                    String choice = request.getParameter(memname);
                    String query = "Insert into finalallocation values(?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, choice);
                    pstmt.setString(2,memname);
                    int i = pstmt.executeUpdate();
                    out.println("<tr>");
                    out.println("<td> <font size='7'><b><i>"+ memname +"</i></b></font></td>");
                    out.println("<td> <font size='7'><b><i>"+ choice +"</i></b></font></td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

  
}
