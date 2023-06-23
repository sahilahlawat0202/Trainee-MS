package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    //create the query
    private static final String INSERT_QUERY_1 ="INSERT INTO personalinformation(uniqueID, firstname, lastname, dob, gender, nationality, contactnumber, email, permanantaddress, city, state, zip, country) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_QUERY_3 ="INSERT INTO internshipdetails(uniqueID, startdate, enddate, fulltime, interest) VALUES(?,?,?,?,?)";
    private static final String INSERT_QUERY_2 ="INSERT INTO educationbackground(uniqueID, university, major, currentyearofstudy, cgpa, yearofgraduation) VALUES(?,?,?,?,?,?)";
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set Content type
        res.setContentType("text/hmtl");
        //read the form values
        String uniqueID = req.getParameter("uniqueID");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        String Nationality = req.getParameter("Nationality");
        String Contact = req.getParameter("Contact");
        String Email = req.getParameter("E-mail");
        String Address = req.getParameter("Address");
        String city = req.getParameter("city");
        String State = req.getParameter("State");
        String ZIP = req.getParameter("ZIP");
        String Country = req.getParameter("Country");
        String startdate = req.getParameter("start-date");
        String enddate = req.getParameter("end-date");
        String fulltime = req.getParameter("fulltime");
        String interest = req.getParameter("interest");
        String major = req.getParameter("major");
        String university = req.getParameter("uni");
        String year = req.getParameter("year");
        String cgpa = req.getParameter("cgpa");
        String yog = req.getParameter("yog");
        
        
        //load the jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //create the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///trainee","root","");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY_1);){
            //set the values
            ps.setString(1, fname+dob);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, Nationality);
            ps.setString(7, Contact);
            ps.setString(8, Email);
            ps.setString(9, Address);
            ps.setString(10, city);
            ps.setString(11, State); 
            ps.setString(12, ZIP);
            ps.setString(13, Country);
           

            //execute the query
            int count = ps.executeUpdate();

            if(count==0) {
                pw.println("Record not stored into database");
            }else {
                pw.println("Record Stored into Database");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///trainee","root","");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY_2);){
            //set the values
            ps.setString(1, fname+dob);
            ps.setString(2, university);
            ps.setString(3, major);
            ps.setString(4, year);
            ps.setString(5, cgpa);
            ps.setString(6, yog);
           

            //execute the query
            int count = ps.executeUpdate();

            if(count==0) {
                pw.println("Record not stored into database");
            }else {
                pw.println("Record Stored into Database");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///trainee","root","");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY_3);){
            //set the values
            ps.setString(1, fname+dob);
            ps.setString(2, startdate);
            ps.setString(3, enddate);
            ps.setString(4, fulltime);
            ps.setString(5, interest);
          

            //execute the query
            int count = ps.executeUpdate();

            if(count==0) {
                pw.println("Record not stored into database");
            }else {
                pw.println("Record Stored into Database");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }

        //close the stream
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}