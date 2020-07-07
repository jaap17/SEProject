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
public class evenstoresubjects extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
         HttpSession sess = request.getSession(false);
        
        if( sess.getAttribute("hod") != null)
        {
            String username = (String) sess.getAttribute("hod");
            sess.setAttribute("hod",username);
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
            Statement stmt = conn.createStatement();
            String math2 = request.getParameter("AF201");
            String ep = request.getParameter("AF212");
            String css = request.getParameter("CT212");
            String html = request.getParameter("CT213");
            String cp2 = request.getParameter("CT215");
            String daa = request.getParameter("CE414");
            String dm = request.getParameter("CE415");
            String se = request.getParameter("CE418");
            String csa = request.getParameter("CE417");
            String jt = request.getParameter("CE410");
            String tafl = request.getParameter("CE614");
            String cn = request.getParameter("CE611");
            String oose = request.getParameter("CE620");
            String sdp = request.getParameter("CE621");
            String soa = request.getParameter("CE617");
            try(PrintWriter out = response.getWriter())
            {
                if (math2 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF201'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(math2.equals("AF201"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF201'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if (ep == null)
                {
                   ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF212'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(ep.equals("AF212"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF212'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if (css == null)
                {
                   ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT212'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(css.equals("CT212"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT212'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                 
                if (html == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT213'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(html.equals("CT213"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT213'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(cp2 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT215'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(cp2.equals("CT215"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT215'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(daa == null)
                {
                    //out.println("Maths-II is not selected");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE414'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(daa.equals("CE414"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE414'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(dm == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE415'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(dm.equals("CE415"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE415'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(se == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE418'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(se.equals("CE418"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE418'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(csa == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE417'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(csa.equals("CE417"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE417'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(jt == null)
                {
                   ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE410'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(jt.equals("CE410"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE410'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                
                if(tafl == null)
                {
                    //out.println("Maths-II is not selected");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE614'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(tafl.equals("CE614"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE614'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(cn == null)
                {
                    //out.println("Maths-II is not selected");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE611'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(cn.equals("CE611"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE611'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(oose == null)
                {
                    //out.println("Maths-II is not selected");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE620'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(oose.equals("CE620"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE620'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(sdp == null)
                {
                    //out.println("Maths-II is not selected");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE621'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(sdp.equals("CE621"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE621'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                
                if(soa == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='C030'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                else if(soa.equals("CE617"))
                {
                    //out.println("You have selected Maths-II<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE617'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId , CourseName of the selected subject are:"+cid+" "+cname+"<h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data Inserted successfully");
                    }
                }
                 String show ="Select * from courselist where Semester='1' or Semester='3' or Semester='5'";
                Statement fetch = conn.createStatement();
                ResultSet fac = fetch.executeQuery(show);
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
               
                out.println("<a href='TaskSelection.html'><font size='8' color='green'>Home</font></a>");
                //out.println("</form>");
                out.println("</li>");
                out.println("<li style='float:right'>");
                out.println("<a href='logout.jsp'><font color='green' size='8'>Logout</font></a>");
                out.println("</li>");
               
                out.println("</ul>");
                out.println("<hr>");
                out.println("<center>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td> <font size='7'><b><i> CourseId  </i></b> </font> </td>");
                out.println("<td> <font size='7'><b><i> CourseName  </i></b> </font> </td>");
                out.println("</tr>");
                while(fac.next())
                {
                    out.println("<tr>");
                    
                    String cid = fac.getString("CourseId");
                    String cname = fac.getString("CourseName");
                    out.println("<td> <font size='7'><b><i>"+ cid+ "</i></b> </font> </td>");
                    out.println("<td> <font size='7'><b><i>"+ cname + "</i></b> </font> </td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br><br>");
                out.println("<form action='generateforms' method='POST'>");
                out.println("<input type='submit' name='ODD' value='GenerateForms'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
                out.println("<form action='generateforms' method='POST'>");
                out.println("<input type='sumbit' name='EVEN' value='GenerateForms'>");
                out.println("</form>");
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
