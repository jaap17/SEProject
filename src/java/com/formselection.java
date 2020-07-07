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
public class formselection extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession sess = request.getSession(false);
        if(sess.getAttribute("username") == null)
        {
            response.sendRedirect("login.html");
        }
        else
        {
            String user = (String)sess.getAttribute("username");
            sess.setAttribute("username", user);
            try(PrintWriter out = response.getWriter())
            {
                out.println("<html>");
                //out.println("<?php include 'base1.php' ?>");
                out.println("<head>");
                out.println("<link href='test.css' rel='stylesheet'>");
                out.println("<link href='test1.css' rel='stylesheet'");
                out.println("</head>");
            
                out.println("<body>");
                out.println("<center>");
                out.println("<h2>Select the type of Semester for which the choice filling form has to be generated</h2>");
                out.println("<h3>");
                out.println("<form action='choicefillingform' method='POST'>");
                out.println("<input type='submit' value='ODD' name='ODD'>");
                
                out.println("</form>");
                out.println("<form action='choicefillingform' method='POST'>");
                 out.println("<input type='submit' value='EVEN' name='EVEN'>");
                out.println("</form>");
                out.println("</h3>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

  

}
