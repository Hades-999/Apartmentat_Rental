/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class login extends HttpServlet {

    public void doGet(ServletRequest request,ServletResponse response)
    {
        try
        {
            Connection con=null;
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            String query = "select email,password from user where email = "+"'"+email+"'"+" and password  = '"+password+"'";
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) 
                System.out.print("Login succesful");
            else 
                System.out.print("You are not registered user");
        }
        catch(  ClassNotFoundException | SQLException e)
        {
                System.out.print("Got an exception! ");
                System.err.println(e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
