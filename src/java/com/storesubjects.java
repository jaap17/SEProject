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
public class storesubjects extends HttpServlet {

  
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
            String elcp = request.getParameter("CT116");
            String html = request.getParameter("CT113");
            String css = request.getParameter("CT112");
            String math1 = request.getParameter("AF111");
            String beee = request.getParameter("AF122");
            String math3 = request.getParameter("AF301");
            String dsa = request.getParameter("CE310");
            String oopj = request.getParameter("CE311");
            String ddc = request.getParameter("CE308");
            String dbms = request.getParameter("CE313");
            String net = request.getParameter("CE509");
            String os = request.getParameter("CE513");
            String at = request.getParameter("CE510");
            String aa = request.getParameter("CE514");
            String mfp = request.getParameter("CE502");
            
            try(PrintWriter out = response.getWriter())
            {
                if(elcp == null)
                {
                    //out.println("ELCP not selected");
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT116'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(elcp.equals("CT116"))
                {
                    //out.println("ELCP is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT116'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                
                if(css == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT112'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(css.equals("CT112"))
                {
                    //out.println("Engineering Mechanics is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT112'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                 
                if(html == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT113'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(html.equals("CT113"))
                {
                    //out.println("Engineering Graphics is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CT113'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                
                if(math1 == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF111'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(math1.equals("AF111"))
                {
                    //out.println(" is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF111'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(beee == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF122'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(beee.equals("AF122"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF122'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"<br></h1>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(math3 == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF301'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(math3.equals("AF301"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='AF301'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"<br></h1>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                
                if(dsa == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE310'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(dsa.equals("CE310"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE310'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(ddc == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE308'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(ddc.equals("CE308"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE308'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(dbms == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE313'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(dbms.equals("CE313"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE313'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(oopj == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE311'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(oopj.equals("CE311"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE311'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(net == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE509'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(net.equals("CE509"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE509'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                    
                }
                
                
                if(os == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE513'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(os.equals("CE513"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE513'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                if(at == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE510'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(at.equals("CE510"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE510'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                
                if(aa == null)
                {
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE514'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(aa.equals("CE514"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE514'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
                    }
                }
                
                
                if(mfp == null)
                {
                     ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE502'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into nonselectedcourses values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                    }
                }
                else if(mfp.equals("CE502"))
                {
                    //out.println("The Subject is Selected<br>");
                    ResultSet rs = stmt.executeQuery("Select * from DepartmentalCourses where CourseId='CE502'");
                    while(rs.next())
                    {
                        String cid = rs.getString("CourseId");
                        String cname = rs.getString("CourseName");
                        int csem = rs.getInt("Semester");
                        //out.println("<h1>The CourseId and CourseName of the Selected Course are:"+cid+" "+cname+" Semester:"+csem+"</h1><br>");
                        PreparedStatement pstmt = conn.prepareStatement("Insert into CourseList values(?,?,?)");
                        pstmt.setString(1,cid);
                        pstmt.setString(2,cname);
                        pstmt.setInt(3,csem);
                        int i = pstmt.executeUpdate();
                        //out.println("Data inserted into CourseList Successfully");
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
               
                out.println("<form action='TaskSelection' method='POST'>");
               out.println("<input type='submit' value='Homepage'>");
               out.println("</form>");
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
