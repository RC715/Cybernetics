/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybernetics.beans;

/**
 *
 * @author Home
 */
public class Area {
    int areaid;
    int lid;

    public Area() {
    }

    public Area(int areaid, int lid) {
        this.areaid = areaid;
        this.lid = lid;
    }

    public int getAreaid() {
        return areaid;
    }

    public int getLid() {
        return lid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }
    
    
}
