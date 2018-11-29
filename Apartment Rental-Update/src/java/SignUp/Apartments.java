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
public class Apartments extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String prop_add=request.getParameter("prop_add");
        String prop_type=request.getParameter("prop_type");
        String ap_type=request.getParameter("ap_type");
        int price=Integer.parseInt(request.getParameter("price"));
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");      		
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            String sql="insert into apartment values(?,?,?,price)";
            st=conn.prepareStatement(sql);
            st.setString(1,prop_add);
            st.setString(2,prop_type);
            st.setString(3,ap_type);
            st.executeUpdate();
            out.println("<script>alert('Upload succesful');</script>");
        }
        catch(Exception e)
        {
            out.println(e);
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
            throws ServletException, IOException {
        processRequest(request, response);
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
