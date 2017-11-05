/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;

import com.cybernetics.beans.Agent;
import com.cybernetics.beans.AgentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Chaturvedi
 */
public class update extends HttpServlet {
   
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

        String str1=request.getParameter("txt4");
        String str2=request.getParameter("txt1");
        String str3=request.getParameter("txt2");
        String str4=request.getParameter("type");
        String str5=request.getParameter("txt3");
        String str6=request.getParameter("txt5");
        String str7=request.getParameter("domain");
        try {
            
           Agent ab=new Agent();
           ab.setUsername(Integer.parseInt(str1));
           ab.setAname(str2);
           ab.setEmailid(str3+"@"+str7);
           ab.setDept(str4);
           ab.setStatus(Integer.parseInt(str5));
           ab.setCaseid(Integer.parseInt(str6));
           AgentDAO ad =new AgentDAO();
           ad.create(ab);
           response.sendRedirect("ChiefAgentDetails?id=1");
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
