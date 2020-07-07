/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author JAAP B ANJARIA
 */
public class loginservlet extends HttpServlet {

     protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
        String username = request.getParameter("uname");
        String pass = request.getParameter("pass");
        Deptmemberregister lda = new Deptmemberregister();
        if (lda.check(username, pass))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
            rd.forward(request, response);
            
        }
        else
        {
            response.sendRedirect("invalidlogin.html");
        }
  }

}
