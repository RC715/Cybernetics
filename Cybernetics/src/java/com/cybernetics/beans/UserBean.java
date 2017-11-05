/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cybernetics.beans;

/**
 *
 * @author RAHUL
 */
public class UserBean {
int username;
String passwrd;
String OTP;
String Dept;
String email;
public UserBean(){}
public void setOTP(String u) {
        this.OTP = u;
    }
public void setDept(String u) {
        this.Dept = u;
    }
public void setUsername(int u) {
        this.username = u;
    }
public void setPassword(String pass) {
        this.passwrd = pass;
    }
public void setEmail(String email) {
        this.email = email;
    }
 public String getOTP() {
        return OTP;
    } public String getDept() {
        return Dept;
    }

 public int getUsername() {
        return username;
    }
  public String  getPassword() {
        return passwrd;
    }
   public String getEmail() {
        return email;
    }
}
