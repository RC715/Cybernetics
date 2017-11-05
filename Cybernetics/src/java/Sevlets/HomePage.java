/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sevlets;
import com.cybernetics.beans.IdBean;
import com.cybernetics.beans.IdDao;
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
 * @author RAHUL
 */
public class HomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int flag=0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //response.sendRedirect("http://localhost:8084/Cybernetics/ActualHomePage");
String str=request.getParameter("Id");
int id=Integer.parseInt(str);
IdDao idd=new IdDao();
ArrayList<IdBean> a1 = idd.findAll();
for (IdBean ib : a1) {
if(ib.getId()==id){
    flag=1;
break;}
}
if(flag==1){        RequestDispatcher rr=request.getRequestDispatcher("Title.html");
        rr.include(request, response);
        RequestDispatcher r=request.getRequestDispatcher("Header.html");
        r.include(request, response);
                 RequestDispatcher r1=request.getRequestDispatcher("WEB-INF/Login.html");
        r1.include(request, response);
         RequestDispatcher r2=request.getRequestDispatcher("Sidebar.html");
        r2.include(request, response);
}
 else{
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomePage at " + "Error Occured" + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
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
