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
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author HP
 */
public class login extends HttpServlet {

    public void processRequest(ServletRequest request,ServletResponse response)throws ServletException, IOException
    {
        try
        {
            int x=1;
            Connection con=null;
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            String query = "select email,password from user where email = "+"'"+email+"'"+" and password  = '"+password+"'";
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                x=1;
            }
            if(x==1)
            {
                out.println("<script>window.location.replace('landlord_dashboard.html');</script>");
            }
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
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
