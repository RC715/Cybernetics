/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

/**
 *
 * @author Home
 */
public class Chief {
    int chid;
    int cid;
    int hid;
    int aid;

    public Chief() {
    }

    public Chief(int chid, int cid, int hid, int aid) {
        this.chid = chid;
        this.cid = cid;
        this.hid = hid;
        this.aid = aid;
    }

    public int getChid() {
        return chid;
    }

    public int getCid() {
        return cid;
    }

    public int getHid() {
        return hid;
    }

    public int getAid() {
        return aid;
    }

    public void setChid(int chid) {
        this.chid = chid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    
   
}
