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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAAP B ANJARIA
 */
public class viewallocation1 extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
          if(sess.getAttribute("facultyuser") != null)
        {
            String fac1 = (String) sess.getAttribute("facultyuser");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root", "");
                Statement stmt = conn.createStatement();
                String query = "Select MemberName from facultylist where MemberId=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, fac1);
                ResultSet rs1 = pstmt.executeQuery();

                try(PrintWriter out = response.getWriter())
                {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");  
                    while(rs1.next())
                    {
                         String name = rs1.getString("MemberName");
                        out.println("<font size='7'><b><i>You are signed in as "+ name +"</i></b></font>");
                    }
                    out.println("<ul>");
                
                
                    out.println("</li>");
                    out.println("<li style='float:right'>");
                    out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("<hr>");
                    Statement fetch = conn.createStatement();
                    String sql = "Select * from finalallocation";
                    ResultSet  rs = fetch.executeQuery(sql);
                    if(rs.next() == false)
                    {
                        out.println("<font size='7'>Allocation not Complete</font>");
                    }
                    else
                    {
                        out.println("<table border='1'>");
                        out.println("<tr>");
                        out.println("<td><font size='7'><b><i> FacultyName </i></b></font></td>");
                        out.println("<td><font size='7'><b><i> Subject Allocated </i></b></font></td>");
                        out.println("</tr>");
                        while(rs.next())
                        {
                            String facname = rs.getString("MemberName");
                            String subject = rs.getString("CourseName");
                            out.println("<tr>");
                            out.println("<td><b><i><font size='6'>"+ facname +"</font></b></i></td>");
                            out.println("<td><b><i><font size='6'>"+ subject +"</font></b></i></td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            response.sendRedirect("login.html");
        }
    }
}
