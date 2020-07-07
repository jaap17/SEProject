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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
/**
 *
 * @author JAAP B ANJARIA
 */
public class FacultyHomepage extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
   {
       HttpSession sess = request.getSession(false);
      if(sess != null)
      {
       String memid = request.getParameter("pass");
       sess.setAttribute("facultyuser",memid);
      
       Connection conn;
       try 
       {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root","");
           PreparedStatement stmt = conn.prepareStatement("Select MemberName from facultylist where MemberId=?");
           stmt.setString(1,memid);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next())
           {
               String name = rs.getString("MemberName");
               try(PrintWriter out = response.getWriter())
                {
                    
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");                           
                    out.println("<ul>");
        
                    out.println("<li style='float:right'>");
                    out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("<center>");
                    //out.println(name+"<br>");
                    out.println("<h2>");
                    out.println("Welcome "+name);
                    out.println("</h2>");
                    //out.println("<h2>Link for the choicefilling form</h2>");
                    Cookie[] cookies = request.getCookies();
                   
                    
                    if(cookies != null)
                    {
                            out.println("<h2>Link for the choicefilling form</h2>");
                            for(int i=0;i<cookies.length;i++)
                            {
                                if(cookies[i].getName().equals("odd"))
                                {
                                    out.println("<form action='oddchoicefilling' method='GET'>");
                                    out.println("<h2>");
                                    out.println("<input type='submit' value='ChoiceFillingForm' name='faculty'>");
                                    out.println("</h2>");
                                    out.println("</form>");
                                }
                                else if(cookies[i].getName().equals("even"))
                                {
                                    out.println("<form action='evenchoicefilling' method='GET'>");
                                    out.println("<h2>");
                                    out.println("<input type='submit' value='ChoiceFillingForm' name='faculty'>");
                                    out.println("</h2>");
                                    out.println("</form>");
                                }
                            }
                        }
                    
                    out.println("<h3> Button to the final Allocation list ");
                    out.println("<form action='viewallocation1' method='POST'>");
                    out.println("<input type='submit' value='View the Final Allocation'>");
                    out.println("</form>");
                    out.println("</h3>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                }
       
       
           }
           try(PrintWriter out = response.getWriter())
           {
                    String sql = "Select * from nonselectedfaculties where MemberId=?";
                    PreparedStatement com = conn.prepareStatement(sql);
                    com.setString(1,memid);
                    ResultSet rj = com.executeQuery();
                    while(rj.next())
                        
                    {
                         out.println("<html>");
                    out.println("<head>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'");
                    out.println("</head>");
                    out.println("<body>");
                    String facname = rj.getString("MemberName");
                   
                    out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                     out.println("<font size='7'>");
                    out.println("You are signed in as"+facname);
                    out.println("</font>");
                    out.println("<ul>");
        
                    out.println("<li style='float:right'>");
                    out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("<center>");
                        
                       
                        out.println("<h2><font size='7'><b><i>You are not Selected in the Choice Filling Course Allocation System</i></b></font></h2>");
                         out.println("<h3> Button to the final Allocation list ");
                        out.println("<form action='viewallocation1' method='POST'>");
                        out.println("<input type='submit' value='View the Final Allocation'>");
                        out.println("</form>");
                        out.println("</h3>");
                        out.println("</center>");
                        
                    }
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(FacultyHomepage.class.getName()).log(Level.SEVERE, null, ex);
       }   catch (ClassNotFoundException ex) {
               Logger.getLogger(FacultyHomepage.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      }
      else
      {
          response.sendRedirect("login.html");
      }
       //sess.setAttribute()
      
   }
}
