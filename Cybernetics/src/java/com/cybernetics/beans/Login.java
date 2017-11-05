/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

/**
 *
 * @author Home
 */
public class Login {
    int lid;
    String emailid;
    String phone;
    String link1;
    String pw1;
    String pw2;

    public Login() {
    }

    public Login(int lid, String emailid, String phone, String link1, String pw1, String pw2) {
        this.lid = lid;
        this.emailid = emailid;
        this.phone = phone;
        this.link1 = link1;
        this.pw1 = pw1;
        this.pw2 = pw2;
    }

    public int getLid() {
        return lid;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPhone() {
        return phone;
    }

    public String getLink1() {
        return link1;
    }

    public String getPw1() {
        return pw1;
    }

    public String getPw2() {
        return pw2;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public void setPw1(String pw1) {
        this.pw1 = pw1;
    }

    public void setPw2(String pw2) {
        this.pw2 = pw2;
    }
    
    
}
