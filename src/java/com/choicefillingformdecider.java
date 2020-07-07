/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAAP B ANJARIA
 */
public class choicefillingformdecider extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
      
        if(sess.getAttribute("facultyuser") != null)
        {
            String user = (String) sess.getAttribute("facultyuser");
            sess.setAttribute("facultyuser",user);
            ServletContext context = this.getServletContext();
            
            String odd = (String)context.getAttribute("odd");
            if(odd != null)
            {
                response.sendRedirect("oddchoicefilling");
            }
            String even = (String)context.getAttribute("even");
            if(even != null)
            {
                 response.sendRedirect("evenchoicefilling");
            }
            if(odd == null && even == null)
            {
                response.sendRedirect("login.html");
            }
        }
        
        else
        {
            response.sendRedirect("login.html");
        }
    }

}
