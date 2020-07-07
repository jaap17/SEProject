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

/**
 *
 * @author JAAP B ANJARIA
 */
public class SemesterTypeSelection extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        HttpSession sess = request.getSession();
        if(sess != null)
        {
            String user = (String)sess.getAttribute("username");
            sess.setAttribute("username",user);
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
                out.println("<center><br>");
                out.println("<center><h2>Select the type of Semester (ODD or EVEN )</h2></center> <br>");
                out.println("<center>");
        
                out.println("<h3><form action='Odd' method='POST'>");
                out.println("Click on <input type='submit' value='ODD'> for ODD Semester Selection");
                out.println("</form><br><br>");
           
                out.println("<form action='Even' method='POST'>");
                out.println("Click on <input type='submit' value='EVEN'> for the Even Semester Selection"); 
                out.println("</form></h3>");
                out.println("</center>");  
                out.println("</body>");
                out.println("</html>");
            }
        }
        else
        {
            response.sendRedirect("login.html");
        }
    }
}
