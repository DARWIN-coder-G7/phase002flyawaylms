package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
/**
 *
 * @author Core 2Duo
 */
public class projectservlet extends HttpServlet {
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          HttpSession session = request.getSession(true);
 
 
        Connection con=null;
        Statement st;
        ResultSet rs;
        ArrayList al = new ArrayList();
        ArrayList list = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pr","root","123");
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
 
        }
        try{
            st=con.createStatement();
            rs=st.executeQuery("select * from pr_project");
 
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet1</title>");
            out.println("</head>");
            out.println("<body>");
 
 
 
          //    response.sendRedirect("first.jsp");
 
                if(rs.next())
            {
                 al.add(rs.getString("pname"));
             al.add(rs.getString("remarks"));
                 al.add(rs.getString("cnt"));
                 al.add(rs.getString("bsponsor"));
             al.add(rs.getString("bprowner"));
                 al.add(rs.getString("priority"));
                 list.add(al);
                 session.setAttribute("list",list);
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/project.jsp");
                rd.forward(request,response);
 
 
            }
            else
            {
 
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
                rd.forward(request, response);
 
            }
            out.println("</body>");
            out.println("</html>");
 
        }catch(SQLException e1)
        {
            out.println(e1.getMessage());
        }
        finally
        {
            out.close();
        }
    }
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 
}
