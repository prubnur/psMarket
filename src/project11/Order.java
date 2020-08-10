/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project11;

import java.util.ArrayList;

/**
 *
 * @author isaluja1811
 */
public class Order {
    private int id;
    private float total;
    private String date;
    private int cid;
    
    public Order(int oid, int custid, float t, String odate) {
        this.cid = custid;
        this.total = t;
        this.id = oid;
        this.date = odate;
    }
    
    public int getId() {
        return id;
    }
    
    public float getTotal() {
        return total;
    }
    
    public String getDate() {
        return date;
    }
    
    public int getCustomerId() {
        return cid;
    }
    
}
