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
import java.sql.ResultSet;
import java.sql.Statement;
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
public class demo extends HttpServlet {

   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         HttpSession sess = request.getSession();
        
        if( sess.getAttribute("hod") != null)
        {
            String username = (String) sess.getAttribute("hod");
            sess.setAttribute("hod",username);
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root", "");
            String sql = "Select * from facultychoice ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            try(PrintWriter out = response.getWriter())
            {
                //out.println("Entering into the while loop");
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
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("<hr>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td><font size='6'> <b><i> Faculty Name  </i></b> </font></td>");
                out.println("<td><font size='6'> <b><i> Subjects of the faculties prioritywise  </i></b> </font></td>");
                out.println("<td><font size='6'> <b><i> Your Allocation  </i></b> </font></td>");
                out.println("</tr>");
                out.println("<form action='finalallocation' method='POST'>");
                while(rs.next())
                {
                    String facname = rs.getString("FacultyName");
                    String priority1 = rs.getString("choice1");
                    String priority2 = rs.getString("choice2");
                    String priority3 = rs.getString("choice3");
                    String priority4 = rs.getString("choice4");
                    String priority5 = rs.getString("choice5");
                    out.println("<tr>");
                    out.println("<td><b><i><font size='6'>"+ facname + "</font></i></b></td>");
                    out.println("<td>");
                    out.println("<select>");
                    out.println("<option value='"+priority1+"'>"+priority1+"(Priority1)</option>");
                    out.println("<option value='"+priority2+"'>"+priority2+"(Priority2)</option>");
                    out.println("<option value='"+priority3+"'>"+priority3+"(Priority3)</option>");
                    out.println("<option value='"+priority4+"'>"+priority4+"(Priority4)</option>");
                    out.println("<option value='"+priority5+"'>"+priority5+"(Priority5)</option>");
                    out.println("</select>");
                    out.println("</td>");
                    out.println("<td>");
                   
                    String query = "Select CourseName from courselist";
                    Connection innerconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
                    Statement inner = innerconn.createStatement();
                    ResultSet sub = inner.executeQuery(query);
                    out.println("<select name='"+facname+"'>");
                    while(sub.next())
                    {
                        String name = sub.getString("CourseName");
                        out.println("<option value='"+name+"'>"+name+"</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");
                    
                    out.println("</tr>");
                    
                    
                }
                out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td> </td>");
                out.println("<td> <input type='submit' value='Submit allocation'> </td>");
                out.println("</form>");
                out.println("</tr>");
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
