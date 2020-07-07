/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
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
public class facultyadd extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
        if(sess.getAttribute("hod") != null)
        {
            String id = (String)sess.getAttribute("hod");
            try
            {
                
                sess.setAttribute("hod",id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
            Statement stmt = conn.createStatement();
            
            try(PrintWriter out = response.getWriter())
            {
                String hod = request.getParameter("F001");
                String fac1 = request.getParameter("F002");
                String fac2 = request.getParameter("F003");
                String fac3 = request.getParameter("F004");
                String fac4 = request.getParameter("F005");
                String fac5 = request.getParameter("F006");
                String fac6 = request.getParameter("F007");
                String fac7 = request.getParameter("F008");
                String fac8 = request.getParameter("F009");
                String fac9 = request.getParameter("F010");
                String fac10 = request.getParameter("F011");
                String fac11 = request.getParameter("F012");
                String fac12 = request.getParameter("F013");
                String fac13 = request.getParameter("F014");
                String fac14 = request.getParameter("F015");
                //out.println("<h2>");
               
                if(hod == null)
                {
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F001'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                            
                        }
                }
                else if(hod.equals("F001"))
                {
                       out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F001'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac1 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F002'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac1.equals("F002"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F002'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac2 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F003'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac2.equals("F003"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F003'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac3 == null)
                {
                   ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F004'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac3.equals("F004"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F004'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac4 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F005'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac4.equals("F005"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F005'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac5 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F006'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac5.equals("F006"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F006'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            //out.println("MemberName:"+memname+"<br>");
                            //out.println("Value:"+value);
                            //stmt.executeUpdate("Insert into FacultyList values(memid,memname,value)");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac6 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F007'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac6.equals("F007"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F007'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac7 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F008'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac7.equals("F008"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F008'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac8 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F009'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac8.equals("F009"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F009'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac9 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F010'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac9.equals("F010"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F010'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac10 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F011'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac10.equals("F011"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F011'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac11 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F012'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac11.equals("F012"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F012'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac12 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F013'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac12.equals("F013"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F013'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                
                if(fac13 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F014'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac13.equals("F014"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F014'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                            //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                 if(fac14 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F015'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedfaculties values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                else if(fac14.equals("F015"))
                {
                        //out.println("Selected MemberId:"+hod+"<br>");
                        ResultSet rs = stmt.executeQuery("Select MemberId,MemName from DeptMembers where MemberId='F015'");
                        while(rs.next())
                        {
                            String memid = rs.getString("MemberId");
                            String memname = rs.getString("MemName");
                            //int value = rs.getInt("Value");
                            PreparedStatement pstmt = conn.prepareStatement("Insert into FacultyList values(?,?)");
                            pstmt.setString(1,memid);
                            pstmt.setString(2,memname);
                            //pstmt.setInt(3,value);
                            int i = pstmt.executeUpdate();
                             //out.println("<h3>Faculty "+memname + " is selected<br><br></h3>");
                        }
                }
                 String faculties = "Select * from facultylist";
                 Statement cn = conn.createStatement();
                 ResultSet names = cn.executeQuery(faculties);
                 
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<link href='test.css' rel='stylesheet'>");
                 out.println("<link href='test1.css' rel='stylesheet'>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<center><font size='20' color='cyan'>Course Allocation System</font> </center> <hr>");
                 out.println("<font size='7'><b><i>You are signed in as Dr Pankaj Jalote</i></b></font>"); 
                 out.println("<ul>");
                 out.println("<li style='float:right'>");
                out.println("<form action='TaskSelection' method='POST'>");
                out.println("<input type='submit' value='Homepage'>");
                out.println("</form>");
                out.println("</li>");
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("<hr>");
                 out.println("<table border='1'>");
                 out.println("<tr><td><font size='7'><b><i>  Selected Faculty Name  </i></b></font></td></tr>");
                 while(names.next())
                 {
                    out.println("<tr>");
                    String facname = names.getString("MemberName");
                    out.println("<td><font size='7'>"+facname+"</font></td>");
                    out.println("</tr>");
                 }
                 out.println("</table>");
                 out.println("</body>");
                 out.println("</html>");
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else
        {
            response.sendRedirect("login.html");
        }
    }

   

}
