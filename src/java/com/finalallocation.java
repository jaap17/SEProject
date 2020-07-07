/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author JAAP B ANJARIA
 */
public class finalallocation extends HttpServlet {

   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
   {
        HttpSession sess = request.getSession(false);
        
        if( sess.getAttribute("hod") != null)
        {
            String username = (String) sess.getAttribute("hod");
            sess.setAttribute("hod",username);
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root", "");
            Statement stmt = conn.createStatement();
          
                
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
                out.println("<li>");
                out.println("<form action='TaskSelection' method='POST'>");
                out.println("<input type='submit' value='Homepage'>");
                out.println("</form>");
                out.println("</li>");
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("<hr>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<font size='7'><b><i> FacultyName </i></b></font>");
                out.println("<font size='7'><b><i> Subject Allocated </i></b></font>");
                out.println("</tr>");
                
                Statement fetch = conn.createStatement();
                String sql = "Select * from FacultyList";
                ResultSet  rs = fetch.executeQuery(sql);
                while(rs.next())
                {
                    String facname = rs.getString("MemberName");
                    String subject = request.getParameter(facname);
                    out.println("<tr>");
                    out.println("<td><b><i><font size='6'>"+ facname +"</font></b></i></td>");
                    out.println("<td><b><i><font size='6'>"+ subject +"</font></b></i></td>");
                    String query = "Insert into finalallocation values(?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1,subject);
                    pstmt.setString(2,facname);
                    int i = pstmt.executeUpdate();
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
     else
        {
            response.sendRedirect("login.html");
        }
        
   }

}
