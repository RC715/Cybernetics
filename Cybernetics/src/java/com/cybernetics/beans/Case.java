/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

import java.sql.Date;

/**
 *
 * @author Home
 */
public class Case {
    int caseid;
    
    String description;
    int agentid;
    
    
    public Case() {
    }

    

    public int getCaseid() {
        return caseid;
    }

    

    

    public int getAgentid() {
        return agentid;
    }
 public String getDescription() {
        return description;
    }
   
    public void setCaseid(int cid) {
        this.caseid = cid;
    }
         public void setDescription(String s) {
        this.description = s;
    }

    
    
    public void setAgentid(int aid) {
        this.agentid = aid;
    }

    
   
}
