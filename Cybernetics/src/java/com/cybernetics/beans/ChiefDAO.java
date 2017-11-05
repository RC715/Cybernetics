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
public class ChiefDAO {
    ConnectionPool c = null;
    Connection conn = null;

    public void create(Chief bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "Insert into chief (chid,cid,hid,aid)" + " values(?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getChid());
            pstmt.setInt(2, bean.getCid());
            pstmt.setInt(3, bean.getHid());
            pstmt.setInt(4, bean.getAid());
            
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(Chief bean) {
        
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            
            String sql = "Update chief set cid=?,hid=?,aid=? where chid =?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
           
            pstmt.setInt(4, bean.getChid());
            pstmt.setInt(1, bean.getCid());
            pstmt.setInt(2, bean.getHid());
            pstmt.setInt(3, bean.getAid());
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<Chief> findAll() {
        ArrayList<Chief> al = new ArrayList<Chief>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from chief";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                Chief bean = new Chief();
                bean.setChid(rs.getInt("chid"));
                bean.setCid(rs.getInt("cid"));
                bean.setHid(rs.getInt("hid"));
                bean.setAid(rs.getInt("aid"));
                
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

    public Chief find(int chid) {
        Chief bean=new Chief();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from chief where chid=" + chid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {
                                
              bean.setChid(rs.getInt("chid"));
                bean.setCid(rs.getInt("cid"));
                bean.setHid(rs.getInt("hid"));
                bean.setAid(rs.getInt("aid"));
                                
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

     public void remove(int chid) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "delete from chief where chid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, chid);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }
    
}
