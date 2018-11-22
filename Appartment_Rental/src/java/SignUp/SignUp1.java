/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import javax.servlet.annotation.WebServlet;
import java.io.*;  
import java.sql.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

/**
 *
 * @author HP
 */
@WebServlet(name = "SignUp1", urlPatterns = {"/SignUp1"})
public class SignUp1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String name=request.getParameter("username");
        String acctype=request.getParameter("acctype");
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");      		
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            String sql ="insert into user values(?,?,?,?)";
            
            st=conn.prepareStatement(sql);
            st.setString(1,email);
            st.setString(2,password);
            st.setString(3,name);
            st.setString(4,acctype);
            st.executeUpdate();
            
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }

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
