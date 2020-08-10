/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project11;

/**
 *
 * @author isaluja1811
 */
public class Transaction {
    
    private int id;
    private int oid;
    private int cid;
    private int pid;
    private String pname;
    private float pprice;
    private int pqty;
    private float amount;
    private String odate;
    private String ptype;
    
    public Transaction(int ID, int orderid, int custid, int proid, String proname, float proprice, int proqty, float amt, String orderdate, String protype) {
        this.id = ID;
        this.oid = orderid;
        this.cid = custid;
        this.pid = proid;
        this.pname = proname;
        this.pprice = proprice;
        this.pqty = proqty;
        this.amount = amt;
        this.odate = orderdate;
        this.ptype = protype;
    }

    public String getPtype() {
        return ptype;
    }

    public int getId() {
        return id;
    }

    public int getOid() {
        return oid;
    }

    public int getCid() {
        return cid;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public float getPprice() {
        return pprice;
    }

    public int getPqty() {
        return pqty;
    }

    public float getAmount() {
        return amount;
    }

    public String getOdate() {
        return odate;
    }
    
    
}
