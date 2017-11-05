/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;

import com.cybernetics.beans.UserBean;
import com.cybernetics.beans.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Chaturvedi
 */
public class Authentication extends HttpServlet {
   
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
        String str1=request.getParameter("name");
        String str2=request.getParameter("pass");
        String str3="";
        UserBean ub = new UserBean();
        UserDao ud = new UserDao();
ArrayList<UserBean> a1=ud.findAll();
for(UserBean u:a1){
if(u.getUsername()==(Integer.parseInt(str1))&&u.getPassword().equals(str2))
{
    str3 = u.getDept();
    break;}
else
    str3="Error Logging in!";

}
if(str3.equalsIgnoreCase("Error Logging in!"))
     {   try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentication</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Authentication at " + str3 + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    } 
    else if(str3.equalsIgnoreCase("Agent")){
    response.sendRedirect("AgentHomePage");

    }
 else if (str3.equalsIgnoreCase("Chief")){
     response.sendRedirect("ChiefHomePage");
 }
 else if (str3.equalsIgnoreCase("HeadPanel"))
     response.sendRedirect("HeadPanelHomePage?hid="+str1 );
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
