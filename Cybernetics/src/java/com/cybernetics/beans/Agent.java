/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

/**
 *
 * @author Home
 */
public class Agent {
    int username;
    String aname;
    int areaid;
    int status;
    int hid;
    String emailid;
    int caseid;
    String dept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    public Agent() {
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public void setCaseid(int caseid) {
        this.caseid = caseid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getAname() {
        return aname;
    }

    public int getAreaid() {
        return areaid;
    }

    public int getCaseid() {
        return caseid;
    }

    public String getEmailid() {
        return emailid;
    }

    public int getHid() {
        return hid;
    }

    public int getStatus() {
        return status;
    }

    public int getUsername() {
        return username;
    }

  
}
