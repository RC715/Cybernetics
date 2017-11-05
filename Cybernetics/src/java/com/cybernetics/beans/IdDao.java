/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cybernetics.beans;

import com.cybernetics.jdbc.utilities.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author RAHUL
 */
public class IdDao {
public void create(IdBean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Insert into login2 (username ,id )  values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getUsername());
            pstmt.setInt(2, bean.getId());

            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }
 public ArrayList<IdBean> findAll() {
        ArrayList<IdBean> al = new ArrayList<IdBean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {

            String sql = "Select * from login2";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                IdBean bean = new IdBean();
                bean.setUsername(rs.getInt("username"));
                bean.setId(rs.getInt("id"));
                al.add(bean);
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
         c.putConnection(conn);
        }
        return al;
    }

    public static void main(String[] args) {
        IdBean bean=new IdBean();
        bean.setUsername(25);
        bean.setId(27);
        IdDao id1=new IdDao();
        id1.create(bean);
    }
}
