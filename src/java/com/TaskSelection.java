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
public class TaskSelection extends HttpServlet {

   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
   {
       HttpSession sess = request.getSession();
      
       if(sess != null)
       {
           String user =(String) sess.getAttribute("hod");
           sess.setAttribute("hod",user);
           try(PrintWriter out = response.getWriter())
           {
            out.println("<html>");
            //out.println("<?php include 'base1.php' ?>");
            out.println("<head>");
            out.println("<link href='test.css' rel='stylesheet'>");
            out.println("<link href='test1.css' rel='stylesheet'");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
            out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>");
            out.println("<ul>");
        
            out.println("<li style='float:right'>");
            out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
            out.println("</li>");
            out.println("</ul>");
            out.println("<hr>");
            out.println("<center><br>");
            //out.println("<h2>"+user+"</h2>");
            out.println("<h2><b>Welcome to Your Home Page HOD SIR!!!</b></h2>");
            out.println("<h3>Enter the respective link for carrying out the further task <br><br><br>");
            out.println("<form action='SemesterTypeSelection' method='POST'>");
            out.println("<input type='submit' name='submit' value='Subject Registration'>");
            out.println("</form>");
         
            out.println("<br><br>");
            //out.println("<br><br>");
            
            out.println("<form action='FacultyRegistration' method='POST'>");
            out.println("<input type='submit' name='Faculty Registration' value='Faculty Registration'>");
            out.println("</form>");
            out.println("<br><br>");
            out.println("<form action='demo' method='GET'>");
            out.println("<input type='submit' name='submit' value='Choice Filling Course Allocation'>");
            out.println("</form>");
            //out.println("<h3>Enter the respective link for carrying out the further task <br><br><br>");
            out.println("<form action='Nonchoicefillingallocation' method='GET'>");
            out.println("<input type='submit' name='submit' value='Non Choice Filling Course Allocation'>");
            out.println("</form>");
            
            out.println("<form action='viewallocation' method='POST'>");
            out.println("<input type='submit' value='View Final Allocation'></h3>");
            out.println("</form>");
           
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
