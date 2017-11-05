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
public class AgentDAO {
    
ConnectionPool c = null;
    Connection conn = null;

    public void create(Agent bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "Insert into agent" + " values(?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getUsername());
            pstmt.setString(2, bean.getAname());
            pstmt.setInt(3, bean.getAreaid());
            pstmt.setInt(4, bean.getStatus());
            pstmt.setInt(5, bean.getHid());
            pstmt.setString(6, bean.getEmailid());
            pstmt.setInt(7, bean.getCaseid());
            pstmt.setString(8, bean.getDept());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(Agent bean) {
        
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            
            String sql = "Update agent set aname=?,areaid=?,status=?,hid=?,emailid=?,caseid=?,dept=? where username =?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
           
            pstmt.setInt(8, bean.getUsername());
            pstmt.setString(1, bean.getAname());
            pstmt.setInt(2, bean.getAreaid());
            pstmt.setInt(3, bean.getStatus());
            pstmt.setInt(4, bean.getHid());
            pstmt.setString(5, bean.getEmailid());
            pstmt.setInt(6, bean.getCaseid());
           pstmt.setString(7, bean.getDept());
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<Agent> findAll() {
        ArrayList<Agent> al = new ArrayList<Agent>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from agent";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                Agent bean = new Agent();
                bean.setUsername(rs.getInt("username"));
                bean.setAname(rs.getString("aname"));
                bean.setAreaid(rs.getInt("areaid"));
                bean.setStatus(rs.getInt("status"));
                bean.setHid(rs.getInt("hid"));
                bean.setEmailid(rs.getString("emailid"));
                bean.setCaseid(rs.getInt("caseid"));
                bean.setDept(rs.getString("dept"));
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

    public Agent find(int aid) {
        Agent bean=new Agent();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "select * from agent where aid=" + aid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {
                                
                 bean.setUsername(rs.getInt("username"));
                bean.setAname(rs.getString("aname"));
                bean.setAreaid(rs.getInt("areaid"));
                bean.setStatus(rs.getInt("status"));
                bean.setHid(rs.getInt("hid"));
                bean.setEmailid(rs.getString("emailid"));
                bean.setCaseid(rs.getInt("caseid"));
                bean.setDept(rs.getString("dept"));
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

     public void remove(int aid) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = (Connection) c.getConnection();
            String sql = "delete from agent where username=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, aid);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }
    
   
}