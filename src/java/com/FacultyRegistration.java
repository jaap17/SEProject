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
public class FacultyRegistration extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
   {
       HttpSession sess = request.getSession();
       if(sess.getAttribute("hod") != null)
       {
          String id = (String)sess.getAttribute("hod");
          sess.setAttribute("hod",id);
          
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers");
           try(PrintWriter out = response.getWriter())
           {
                out.println("<html>");
                out.println("<head>");
                out.println("<link href='test.css' rel='stylesheet'>");
                out.println("<link href='test1.css' rel='stylesheet'");
                out.println("</head>");
                out.println("<body>");
                out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>");
                out.println("<ul>");
                out.println("<li style='float:right'>");
               
                out.println("<form action='TaskSelection' method='POST'>");
                out.println("<input type='submit' value='Homepage'>");
                out.println("</form>");
                //out.println("</form>");
                out.println("</li>");
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
               
                out.println("</ul>");
                out.println("<hr>");
                out.println("<center>");
                out.println("<h2>Please Select the Faculties who will be participating in the Choice Filling Process</h2>");
                out.println("<h3>");
                out.println("<form action='facultyadd' method='POST'>");
                while(rs.next())
                {
                    String memid = rs.getString("MemberId");
                    String memname = rs.getString("MemName");
                    //int id = rs.getInt("Value");
                    out.println("<input type='checkbox' name="+memid+" value="+memid+">"+ memname);
                    //out.println("MemberId:"+memid);
                    //out.println("MemberName:"+memname);
                    out.println("<br><br>");
                }
                out.println("<input type='submit' value='Submit Selected Faculties'>");
                out.println("</h3>");
                out.println("</form>");
                out.println("</center>");
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
