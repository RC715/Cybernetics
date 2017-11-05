/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cybernetics.beans;

import com.cybernetics.jdbc.utilities.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAHUL
 */
public class EmailServlet extends HttpServlet {
    int flag=0;
   public static final String FROM = "cybernetics.prs@gmail.com";
public static final String PASSWORD = "rupalimata";
public static final String HOST = "smtp.gmail.com";
public static final String PORT = "465";
String str="sent";
 public int randomInt(){
        int a=(int)(Math.random()*1000);
        return a;}
public String randomLinkGenerator(String name){

    int n1,n2;
    n1=randomInt();
     String s = n1+name;
    n2=Integer.parseInt(name);
    String strng="http://localhost:8084/Cybernetics/HomePage?";
strng=strng+"Id="+s;
IdBean bean=new IdBean();
IdDao st = new IdDao();
        ArrayList<IdBean> al = st.findAll();
for (IdBean ib : al) {
if(ib.getUsername()==n2)
{ flag=1;
    ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
        String sql = "Update login2 Set id=? where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(s));
            pstmt.setInt(2, n2);
            pstmt.execute();
}catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }}
}
if(flag==0){
        bean.setUsername(n2);
        bean.setId(Integer.parseInt(s));
        IdDao id1=new IdDao();
        System.out.println(bean.getUsername());
        id1.create(bean);
        strng=strng+bean.getUsername();}
return strng;}
	public static void sendMail(String to, String subject, String text){
		String d_host = HOST;
		String d_port  = PORT;
		String m_to = to;
		String m_subject = subject;
		String m_text = text;
Properties props = new Properties();
props.put("mail.smtp.user", FROM);
props.put("mail.smtp.host", d_host);
props.put("mail.smtp.port", d_port);
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", d_port);
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();
		try {
            Authenticator auth = new Authenticator() {


public PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(FROM, PASSWORD);
			}
		};
Session session1 = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session1);
msg.setText(m_text);
msg.setSubject(m_subject);
msg.setFrom(new InternetAddress(FROM));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
		Transport.send(msg);
		}
		catch (Exception mex) {
            			mex.printStackTrace();
		}
	}

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
        UserDao st = new UserDao();
        ArrayList<UserBean> al = st.findAll();
        for (UserBean s : al) {
                    if((request.getParameter("name").equals(s.getUsername()+""))&& request.getParameter("pass").equals(s.getPassword()))
                    {
                        sendMail(s.getEmail(), "Testing", randomLinkGenerator(request.getParameter("name")));str="sent";break;}
            else
       str="Sorry";
            }


        PrintWriter out = response.getWriter();
        try {
             out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> " + str+ "</h1>");
            out.println("</body>");
            out.println("</html>");

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
