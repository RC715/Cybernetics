/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cybernetics.beans;

import java.sql.Blob;

/**
 *
 * @author RupaliBhatnagar
 */
public class CaseDb {
    String caseid;
    String mmid;
   Blob data;
   
    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getMmid() {
        return mmid;
    }

    public void setMmid(String mmid) {
        this.mmid = mmid;
    }

    public Blob getData() {
        return data;
    }

    public void setPicture(Blob data) {
        this.data = data;
    }

    
    
}
