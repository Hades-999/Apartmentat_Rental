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
public class SignUp3 extends HttpServlet {

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
        String curr_add=request.getParameter("curr_add");
        String age=request.getParameter("age");
        String gender=request.getParameter("gender");
        String number=request.getParameter("number");
        String type=request.getParameter("type");
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");      		
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            st=conn.createStatement();
            st.executeUpdate("insert into landlords values('"+curr_add+"','"+age+"','"+gender+"','"+number+"','"+type+"')");              
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
