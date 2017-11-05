/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;

import com.cybernetics.beans.Agent;
import com.cybernetics.beans.AgentDAO;
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
public class RemoveAgent extends HttpServlet {
   
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
        
        AgentDAO ad=new AgentDAO();
        ArrayList<Agent> al=ad.findAll();
         RequestDispatcher rr=request.getRequestDispatcher("CADTitle.html");
        rr.include(request, response);
RequestDispatcher r=request.getRequestDispatcher("Header.html");
        r.include(request, response);
               RequestDispatcher r1=request.getRequestDispatcher("ChiefMenu.html");
               r1.include(request, response);
               if(Integer.parseInt(request.getParameter("id"))== 1){
        out.println("<h1><b>Deleted</b></h1>");}
               out.println("<br><br><br><br><br><br><div><form action=\"Delete\" method=\"post\"><select name=\"AID\" style=\"margin-left:400px;border:2px padding : 100px\">");
               for(Agent a:al)
        {
                   out.println("<option  value=\""+a.getUsername()+"\">"+a.getUsername()+"</option>");

        }
               out.println("</option></select><br><br><br><br>"
                       + "<input type=\"submit\" id=\"Delete\"value=\"Delete\" style=\"margin-left:400px;border:2px padding : 100px width : 500px\" >"+"</form></div>");
RequestDispatcher r2=request.getRequestDispatcher("Sidebar.html");
        r2.include(request, response);
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveAgent</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveAgent at " + request.getContextPath () + "</h1>");
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
