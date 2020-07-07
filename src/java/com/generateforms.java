/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAAP B ANJARIA
 */
public class generateforms extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession sess = request.getSession(false);
        if(sess.getAttribute("username") != null)
        {
            String username = (String) sess.getAttribute("username");
            sess.setAttribute("username",username);
            String odd = request.getParameter("ODD");
            String even = request.getParameter("EVEN");
            if(odd != null)
            {
                Cookie cookie = new Cookie("odd","odd");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                try(PrintWriter out = response.getWriter())
                {
                    out.println("<html>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'>");
                    out.println("<body>");
                    out.println("<form action='choicefillingform' method='POST'>");
                    out.println("<input type='submit' name='ODD' value='View ChoiceFillingForm'>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            else if(even != null)
            {
                Cookie cookie = new Cookie("even","even");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                 try(PrintWriter out = response.getWriter())
                {
                    out.println("<html>");
                    out.println("<link href='test.css' rel='stylesheet'>");
                    out.println("<link href='test1.css' rel='stylesheet'>");
                    out.println("<body>");
                    out.println("<form action='choicefillingform' method='POST'>");
                    out.println("<input type='submit' name='EVEN' value='View ChoiceFillingForm'>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</hrml>");
                }
            }
        }
    }


}
