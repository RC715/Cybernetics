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
 * @author Rohit Chaturvedi
 */
public class HeadPanelAssignDAO {
 ConnectionPool c = null;
    Connection conn = null;

    public void create(HeadPanelAssign bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "Insert into headpanelassign (hid,area)" + " values(?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getHid());

            pstmt.setString(2, bean.getArea());


            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(HeadPanelAssign bean) {

        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();

            String sql = "Update headpanelassign set area=? where hid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setInt(2, bean.getHid());
            pstmt.setString(1, bean.getArea());

            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<HeadPanelAssign> findAll() {
        ArrayList<HeadPanelAssign> al = new ArrayList<HeadPanelAssign>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from headpanelassign";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                HeadPanelAssign bean = new HeadPanelAssign();
                bean.setHid(rs.getInt("hid"));
                bean.setArea(rs.getString("area"));

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

    public HeadPanelAssign find(int cid) {
        HeadPanelAssign bean=new HeadPanelAssign();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from headpanelassign where hid=" + cid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {

                bean.setHid(rs.getInt("hid"));
                bean.setArea(rs.getString("area"));

            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

     public void remove(int cid) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "delete from headpanelassign where hid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, cid);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

}
