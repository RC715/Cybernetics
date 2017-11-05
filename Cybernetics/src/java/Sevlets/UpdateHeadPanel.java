/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;

import com.cybernetics.beans.Case;
import com.cybernetics.beans.CaseDAO;
import com.cybernetics.beans.HeadPanel;
import com.cybernetics.beans.HeadPanelDAO;
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
public class UpdateHeadPanel extends HttpServlet {
   
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
        HeadPanelHomePage h=new HeadPanelHomePage();
        int hid=h.hid1;
        String str1=request.getParameter("txt1");
        String str2=request.getParameter("txt2");
        String str3=request.getParameter("txt3");
        int areaid=Integer.parseInt(str1);
        int cid=Integer.parseInt(str2);
        int aid=Integer.parseInt(str3);
        HeadPanelDAO hd = new HeadPanelDAO();
        HeadPanel hb = new HeadPanel();
        hb.setAid(aid);
        hb.setAreaid(areaid);
        hb.setCid(cid);
        hb.setHid(hid);
        hd.create(hb);
        Case c = new Case();
        c.setAgentid(aid);
        c.setCaseid(cid);
        CaseDAO cd=new CaseDAO();
        cd.create(c);
        response.sendRedirect("AssignCase?id=1");
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateHeadPanel</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateHeadPanel at " + request.getContextPath () + "</h1>");
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
