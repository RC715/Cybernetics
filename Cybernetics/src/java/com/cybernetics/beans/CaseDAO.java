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
public class CaseDAO {
    

    public void create(Case bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            
            String sql = "Insert into `case` (caseid,agentid,description)" + " values(?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getCaseid());
           
            pstmt.setInt(2, bean.getAgentid());
            pstmt.setString(3, bean.getDescription());
            

            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            c.putConnection(conn);


        }
    }

    public void edit(Case bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            
            
            String sql = "Update `case` set agentid=? description=? where caseid=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
           
           pstmt.setInt(3, bean.getCaseid());

            pstmt.setInt(1, bean.getAgentid());
            pstmt.setString(2, bean.getDescription());
           
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

    public ArrayList<Case> findAll() {
        ArrayList<Case> al = new ArrayList<Case>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();

        try {
           
            String sql = "Select * from `case`";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                Case bean = new Case();
                bean.setCaseid(rs.getInt("caseid"));
                bean.setAgentid(rs.getInt("agentid"));
                bean.setDescription(rs.getString("description"));
               
                al.add(bean);
            }
           
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);

        }
        return al;
    }

    public Case find(int cid) {
        Case bean=new Case();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
                        String sql = "select * from `case` where caseid=" + cid;
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) pstmt.executeQuery();
             if (rs.next()) {
                                
                bean.setCaseid(rs.getInt("caseid"));
                bean.setAgentid(rs.getInt("agentid"));
                bean.setDescription(rs.getString("description"));

                
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
         ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
           
            String sql = "delete from `case` where caseid=?";
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
    public static void main(String[] args) {
        
        CaseDAO cd= new CaseDAO();
        ArrayList<Case> al=cd.findAll();
        for(Case c:al)
        {
        System.out.println(c.getAgentid());}
    }
}
