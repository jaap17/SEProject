<%-- 
    Document   : logout
    Created on : 1 Apr, 2020, 6:13:56 PM
    Author     : JAAP B ANJARIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='test.css' rel='stylesheet'>
        <link href='test1.css' rel='stylesheet'>
    </head>
    <body>
        <%
            HttpSession sess = request.getSession(false);
            
            if(sess != null)
            {
                out.println("<h3>You have logged out Succesfully</h3>");
               %>
               <h2>Click here to go to the <a href="login.html"> Homepage </a></h2>
            <%}
            
              else
            {
                response.sendRedirect("login.html");
            }
        %>
    </body>
</html>
