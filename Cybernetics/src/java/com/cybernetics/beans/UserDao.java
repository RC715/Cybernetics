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
public class UserDao {
 public ArrayList<UserBean> findAll() {
        ArrayList<UserBean> al = new ArrayList<UserBean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {

            String sql = "Select * from login";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean bean = new UserBean();
                bean.setUsername(rs.getInt("username"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
                bean.setDept(rs.getString("dept"));
                bean.setOTP(rs.getString("OTP"));
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
UserDao st = new UserDao();
        ArrayList<UserBean> al = st.findAll();
        for (UserBean s : al) {
            System.out.println(s.getUsername());
        }}
}
