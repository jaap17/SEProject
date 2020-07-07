/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CourseAllocation extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        //HttpSession sess = request.getSession(false);
      
            //sess.setAttribute("username",user);
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1", "root", "");
                String sql = "Select CourseName,CourseId from CourseList";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
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
                    out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("<hr>");
                    out.println("<center><br>");
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td> <font size='7'> <b> <i> Subject Name </i> </b> </font> </td>");
                    out.println("<td> <font size='7'><i><b> Choice by different Faculties </b></i></font></td>");
                    out.println("</tr>");
                    while(rs.next())
                    {
                        String cname = rs.getString("CourseName");
                        String cid = rs.getString("CourseId");
                        out.println("<tr>");
                        out.println("<td><font size='6'>"+cname+"</font></td>");
                        out.println("<td>");
                        String query = "Select FacName from facultychoice where priority1='"+cname+"'";
                        Statement inner = conn.createStatement();
                        ResultSet choicenames = inner.executeQuery(query);
                        out.println("<select name='"+cname+"'>");
                        while(choicenames.next())
                        {
                                String facid = choicenames.getString("FacId");
                                //out.println(facid);
                                out.println("<option value='facid'>"+facid+"</option>");
                        }
                        
                        out.println("</td>");
                        out.println("</tr>");
                        
                    }
                    out.println("</table>");
                }
                
           }catch(Exception e)
           {
               System.out.println(e);
           }
        }
    

}
