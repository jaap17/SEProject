<%-- 
    Document   : Welcome
    Created on : 22 Feb, 2020, 5:40:12 PM
    Author     : JAAP B ANJARIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if(session.getAttribute("username") == null )
    {
        response.sendRedirect("login.html");
    }
    String username = request.getParameter("uname");
    if(username != null)
    {
        out.println("Welcome:"+username);
        if(username.equals("F001"))
        {
            HttpSession sess = request.getSession();
            sess.setAttribute("hod",username);
            RequestDispatcher rd = request.getRequestDispatcher("TaskSelection");
            rd.include(request,response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("FacultyHomepage");
            rd.include(request,response);
        }
    }
  %>
  
