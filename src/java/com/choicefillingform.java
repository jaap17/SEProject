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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author JAAP B ANJARIA
 */
public class choicefillingform extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       HttpSession sess = request.getSession(false);
      
       ServletContext context = this.getServletContext();
       String odd = request.getParameter("ODD");
       String even = request.getParameter("EVEN");
       try
       {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
        Statement stmt = conn.createStatement();
        if(odd == null)
        {
             String store = "false";
            context.setAttribute("odd",store);
        }
        if(even == null)
        {
              String store = "false";
            context.setAttribute("even",store);
        }
        if(odd != null)
        {
            
           
            String sql = "Select CourseName,CourseId from courselist where Semester='1' or Semester='3' or Semester='5'";
            ResultSet rs = stmt.executeQuery(sql);
             
              
            try(PrintWriter out = response.getWriter())
            {
                out.println("<html>");
                out.println("<head>");
                out.println("<link href='test.css' rel='stylesheet'>");
                out.println("<link href='test1.css' rel='stylesheet>'");
                out.println("</head>");
                out.println("<body>");
               out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>");
                out.println("<ul>");
                out.println("<li style='float:center'>");
               
                out.println("<form action='TaskSelection' method='POST'>");
                out.println("<input type='submit' value='Homepage'>");
                out.println("</form>");
                
                out.println("</li>");
                
               
                out.println("</ul>");
                out.println("<hr>");
                out.println("<center>");
                out.println("<font size='7'> 1) Please Select atleast One Subject from each of the Semester <br> "
                        + "2) Please don't give same choice for Different priorities rest the choices would not be accepted by the Software. </font>");
                out.println("<table border='1'>");
                    out.println("<tr>");
                    out.println("<td> <font size='7'> <b> <i> Priority </i></b> </font>  </td>  ");
                    out.println("<td> <font size='7'> <b> <i> Subject you want to teach </i></b> </font> </td>");
                    out.println("</tr>");
                    out.println("<form action='storechoices' method='POST'>");
                    out.println("<tr>");
                    out.println("<td><font size='7'> 1 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority1'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                    out.println("<tr>");
                    out.println("<td><font size='7'> 2 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority2'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 3 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority3'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 4 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority4'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 5 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority5'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    
                    out.println("<td><input type='submit' name='submit' value='SubmitChoices'></td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</table>");
            }
        }
        else if(even != null)
        {
            String store = "true";
            context.setAttribute("even",store);
            String sql = "Select CourseName,CourseId,Semester from courselist where Semester='2' or Semester='4' or Semester='6'";
            ResultSet rs = stmt.executeQuery(sql);
            
            try(PrintWriter out = response.getWriter())
            {
                out.println("<html>");
                out.println("<head>");
                out.println("<link href='test.css' rel='stylesheet'>");
                out.println("<link href='test1.css' rel='stylesheet'");
                out.println("</head>");
                out.println("<body>");
                if(sess.getAttribute("hod") != null)
                {
                    out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>"); 
                     out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>");
                    out.println("<ul>");
                    out.println("<li style='float:right'>");
               
                    out.println("<a href='TaskSelection.html'><font size='8' color='green'>Home</font></a>");
                //out.println("</form>");
                    out.println("</li>");
                    out.println("<li style='float:right'>");
                    out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                    out.println("</li>");
               
                    out.println("</ul>");
                }
                out.println("<center>");
               out.println("<table>");
                    out.println("<tr>");
                    out.println("<td> <font size='7'> <b> <i> Priority </i></b> </font>  </td>  ");
                    out.println("<td> <font size='7'> <b> <i> Subject you want to teach </i></b> </font> </td>");
                    out.println("</tr>");
                    out.println("<form action='storechoices' method='POST'>");
                    out.println("<tr>");
                    out.println("<td><font size='7'> 1 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority1'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        int sem = rs.getInt("Semester");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                    out.println("<tr>");
                    out.println("<td><font size='7'> 2 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority2'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                         int sem = rs.getInt("Semester");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"(Semester"+sem+")</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 3 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority3'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                         int sem = rs.getInt("Semester");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"(Semester"+sem+")</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 4 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority4'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        int sem = rs.getInt("Semester");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"(Semester"+sem+")</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    rs.beforeFirst();
                     out.println("<tr>");
                    out.println("<td><font size='7'> 5 </font></td>");
                    out.println("<td>");
                    out.println("<select name='priority5'>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                         int sem = rs.getInt("Semester");
                        out.println("<option value=' "+cname+"'"+ '>'+cname+"(Semester"+sem+")</option>");
                        
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    
                    out.println("<td><input type='submit' name='submit' value='SubmitChoices'></td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</table>");
                    out.println("</html>");
            }
        }
        else if(odd == null && even == null)
        {
           try(PrintWriter out = response.getWriter())
           {
               out.println("<html>");
               out.println("<head>");
               out.println("<link href='test.css' rel='stylesheet'>");
               out.println("<link href='test1.css' rel='stylesheet'");
               out.println("</head>");
               out.println("<body>");
               out.println("<h1> Choice Filing Form  is not Available </h1>");
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
