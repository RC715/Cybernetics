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
public class HeadPanelDAO {
    ConnectionPool c = null;
    Connection conn = null;

    public void create(HeadPanel bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "Insert into headpanel (hid,areaid,cid,aid)" + " values(?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getHid());
            pstmt.setInt(2, bean.getAreaid());
            pstmt.setInt(3, bean.getCid());
            pstmt.setInt(4, bean.getAid());
            
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(HeadPanel bean) {
        
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            
            String sql = "Update headpanel set areaid=?,cid=?,aid=? where hid =?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
           
            pstmt.setInt(1, bean.getAreaid());
            pstmt.setInt(1, bean.getCid());
            pstmt.setInt(2, bean.getAid());
            pstmt.setInt(3, bean.getHid());
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<HeadPanel> findAll() {
        ArrayList<HeadPanel> al = new ArrayList<HeadPanel>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from headpanel";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                HeadPanel bean = new HeadPanel();
                bean.setHid(rs.getInt("hid"));
                bean.setAreaid(rs.getInt("areaid"));
                bean.setCid(rs.getInt("cid"));
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

    public HeadPanel find(int hid) {
        HeadPanel bean=new HeadPanel();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from headpanel where hid=" + hid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {
                                
              bean.setHid(rs.getInt("hid"));
                bean.setAreaid(rs.getInt("areaid"));
                bean.setCid(rs.getInt("cid"));
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

     public void remove(int hid) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "delete from headpanel where hid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, hid);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }
    
}
