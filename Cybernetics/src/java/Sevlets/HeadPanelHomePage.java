/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;

import com.cybernetics.beans.Case;
import com.cybernetics.beans.CaseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Chaturvedi
 */
public class HeadPanelHomePage extends HttpServlet {
  static int hid1;
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
        if(request.getParameter("hid")==null)
            ;
 else{
        String str1=request.getParameter("hid");
        int hid=Integer.parseInt(str1);
        hid1=hid;}
         CaseDAO cd= new CaseDAO();
        ArrayList<Case> al=cd.findAll();
         RequestDispatcher rr=request.getRequestDispatcher("ChiefTitle.html");
        rr.include(request, response);
RequestDispatcher r=request.getRequestDispatcher("Header.html");
        r.include(request, response);
               RequestDispatcher r1=request.getRequestDispatcher("HeadPanelMenu.html");
        r1.include(request, response);
         out.println("<div><table id=\"Details\" border = 1 allign=\"center\">");
        out.println("<tr><td>CaseID</td><td>AgentID</td><td>Description</td></tr>");
        for(Case c:al){
        out.println("<tr><td>"+c.getCaseid()+"</td>"+"<td>"+c.getAgentid()+"</td>"+"<td>"+c.getDescription()+"</td></tr>");
        }
        out.println("</table></div>");
      
         RequestDispatcher r2=request.getRequestDispatcher("Sidebar.html");
        r2.include(request, response);
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HeadPanelHomePage</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HeadPanelHomePage at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
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
