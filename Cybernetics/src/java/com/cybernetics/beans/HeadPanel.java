/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

/**
 *
 * @author Home
 */
public class HeadPanel {
   int hid;
   int areaid;
   int cid;
   int aid;
   
    public HeadPanel() {
    }

    public HeadPanel(int hid, int areaid, int cid, int aid) {
        this.hid = hid;
        this.areaid = areaid;
        this.cid = cid;
        this.aid = aid;
    }

    public int getHid() {
        return hid;
    }

    public int getAreaid() {
        return areaid;
    }

    public int getCid() {
        return cid;
    }

    public int getAid() {
        return aid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

   
}
