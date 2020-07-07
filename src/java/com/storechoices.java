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
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.http.Cookie;
/**
 *
 * @author JAAP B ANJARIA
 */
public class storechoices extends HttpServlet {

   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
   {
       HttpSession sess = request.getSession(false);
       String facname = " ";
       if(sess.getAttribute("facultyuser") != null)
       {
           String facid = (String) sess.getAttribute("facultyuser");
           sess.setAttribute("facultyuser", facid);
           String priority1 = request.getParameter("priority1");
           String priority2 = request.getParameter("priority2");
           String priority3 = request.getParameter("priority3");
           String priority4 = request.getParameter("priority4");
           String priority5 = request.getParameter("priority5");
          
           if(priority1.equals(priority2) || priority2.equals(priority3) || priority3.equals(priority4) || priority4.equals(priority5) || priority1.equals(priority3) || priority1.equals(priority4) || 
                   priority1.equals(priority5) || priority2.equals(priority3) || priority2.equals(priority4) || priority2.equals(priority5) || priority3.equals(priority4) || priority3.equals(priority5) || 
                   priority4.equals(priority5))
           {
               try(PrintWriter out = response.getWriter())
                {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'");
                    out.println("</head>");
                    out.println("<body>");
                    //out.println("Facname:"+facname);
                    out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                    out.println("<font size='7'>");
                    out.println("You are signed in as: "+facname);
                    out.println("</font>");
                    out.println("<form action='logout.jsp'>");
                    out.println("<input type='submit' value='Logout'></font></a>");
                    out.println("</form>");
                   
                    
                    out.println("<form action='FacultyHomepage' method='POST'>");
                    out.println("<input type='submit' value='HomePage'></font></a>");
                    out.println("</form>");
                    
                    out.println("<hr>");
                    out.println("<h3>");
                    out.println("<font size='7'> <b><i> Oops!!! Atleast two fo your choices are the same . Try to do the choicefilling again  </i></b> </font>");
                    out.println("</h3>");
                    Cookie[] cookies = request.getCookies();
                    if(cookies != null)
                    {
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
                    out.println("</body>");
                    out.println("</html>");
                }
           }  
           else
           {
              
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root","");
                    Statement pstmt = conn.createStatement();
                    ResultSet rs = pstmt.executeQuery("Select MemberName from facultylist where MemberId='"+facid+"'");
                    while(rs.next())
                    {
                        facname = rs.getString("MemberName");
                    
                    }
                
                    PreparedStatement stmt = conn.prepareStatement("Insert into facultychoice values(?,?,?,?,?,?,?) ");
                    stmt.setString(1, facid);
                    stmt.setString(7,facname);
                    stmt.setString(2,priority1);
                    stmt.setString(3,priority2);
                    stmt.setString(4,priority3);
                    stmt.setString(5, priority4);
                    stmt.setString(6,priority5);
                    stmt.executeUpdate();
               
               
               
                    String query = "Select choice1,choice2,choice3,choice4,choice5 from facultychoice where FacultyId='"+facid+"'";
                    Statement stm = conn.createStatement();
              
                    ResultSet priorityset =   stm.executeQuery(query);
                    while(priorityset.next())
                    {
                        String choice1 = priorityset.getString("choice1");
                        String choice2 = priorityset.getString("choice2");
                        String choice3 = priorityset.getString("choice3");
                        String choice4 = priorityset.getString("choice4");
                        String choice5 = priorityset.getString("choice5");
                
                        try(PrintWriter out = response.getWriter())
                        {
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<link href='test.css' rel='stylesheet'>");
                            out.println("<link href='test1.css' rel='stylesheet'");
                            out.println("</head>");
                            out.println("<body>");
                            //out.println("Facname:"+facname);
                            out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                            out.println("<font size='7'>");
                            out.println("You are signed in as: "+facname);
                            out.println("</font>");
                            out.println("<form action='logout.jsp'>");
                            out.println("<input type='submit' value='Logout'></font></a>");
                            out.println("</form>");
                   
                    
                            out.println("<form action='FacultyHomepage' method='POST'>");
                            out.println("<input type='submit' value='HomePage'></font></a>");
                            out.println("</form>");
                    
                            out.println("<hr>");
                            out.println("<table>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i>Priority</i></b></font> </td>");
                            out.println("<td> <font size='7'><b><i>Your Choice</i></b></font> </td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i> 1 </i></b></font><t/td>");
                            out.println("<td> <font size='7'><b><i>"+choice1+"</i></b></font><t/td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i> 2 </i></b></font><t/td>");
                            out.println("<td> <font size='7'><b><i>"+choice2+"</i></b></font><t/td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i> 3 </i></b></font><t/td>");
                            out.println("<td> <font size='7'><b><i>"+choice3+"</i></b></font><t/td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i> 4 </i></b></font><t/td>");
                            out.println("<td> <font size='7'><b><i>"+choice4+"</i></b></font><t/td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td> <font size='7'><b><i> 5 </i></b></font><t/td>");
                            out.println("<td> <font size='7'><b><i>"+choice5+"</i></b></font><t/td>");
                            out.println("</tr>");
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
       
       }
       else
       {
           response.sendRedirect("login.html");
       }
   }

}
