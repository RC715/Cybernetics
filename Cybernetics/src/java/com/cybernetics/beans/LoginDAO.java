/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;
import com.cybernetics.jdbc.utilities.ConnectionPool;
import java.sql.*;

import java.util.ArrayList;
/**
 *
 * @author Home
 */
public class LoginDAO {
    ConnectionPool c = null;
    Connection conn = null;

    public void create(Login bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "Insert into login (lid,emailid,phone,link1,pw1,pw2)" + " values(?,?,?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getLid());
            pstmt.setString(2, bean.getEmailid());
            pstmt.setString(3, bean.getPhone());
            pstmt.setString(4, bean.getLink1());
            pstmt.setString(5, bean.getPw1());
            pstmt.setString(6, bean.getPw2());
            
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(Login bean) {
        
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            
            String sql = "Update login set emailid=?,phone=?,link1=?,pw1=?,pw2=? where lid =?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
           
            pstmt.setInt(6, bean.getLid());
            pstmt.setString(1, bean.getEmailid());
            pstmt.setString(2, bean.getPhone());
            pstmt.setString(3, bean.getLink1());
            pstmt.setString(4, bean.getPw1());
            pstmt.setString(5, bean.getPw2());
           
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<Login> findAll() {
        ArrayList<Login> al = new ArrayList<Login>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from login";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                Login bean = new Login();
                bean.setLid(rs.getInt("lid"));
                bean.setEmailid(rs.getString("emailid"));
                bean.setPhone(rs.getString("phone"));
                bean.setLink1(rs.getString("link1"));
                bean.setPw1(rs.getString("pw1"));
                bean.setPw2(rs.getString("pw2"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return al;
    }

    public Login find(int lid) {
        Login bean=new Login();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from login where lid=" + lid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {
                                
                bean.setLid(rs.getInt("lid"));
                bean.setEmailid(rs.getString("emailid"));
                bean.setPhone(rs.getString("phone"));
                bean.setLink1(rs.getString("link1"));
                bean.setPw1(rs.getString("pw1"));
                bean.setPw2(rs.getString("pw2"));
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

     public void remove(int lid) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "delete from login where lid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, lid);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }
    
}
 