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
public class Retrieval extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        response.setContentType("text/html");
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            int x=0;
            Class.forName("com.mysql.jdbc.Driver");      		
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/acadview","root","");
            st = conn.createStatement();
            String location=request.getParameter("location");
            int max=Integer.parseInt(request.getParameter("max"));
            int min=Integer.parseInt(request.getParameter("min"));
            java.sql.PreparedStatement ps=conn.prepareStatement("Select * from apartment where price<=max and price>=min");
            rs=ps.executeQuery();
            while(rs.next())
            {
                String address=rs.getString("address");
                request.setAttribute("address",address);
                String proptype=rs.getString("proptype");
                request.setAttribute("proptype",proptype);
                String apptype=rs.getString("apptype");
                request.setAttribute("apptype",apptype);
                int price=Integer.parseInt(rs.getString("price"));
                request.setAttribute("price", price);
                request.getRequestDispatcher("results.jsp").forward(request, response);
                x++;
            }
            if(x==0)
                out.println("No Results found");
            rs.close();
            st.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
