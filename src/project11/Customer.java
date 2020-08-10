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
public class Customer implements Comparable<Customer>{
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private ArrayList<Product> cartList;
    private ArrayList<Integer> qtyList;
    private float spent;
    
    public Customer(int uid, String uname, String uemail, String uusername, String upassword, float sp) {
        this.id = uid;
        this.name = uname;
        this.email = uemail;
        this.username = uusername;
        this.password = upassword;
        this.cartList = new ArrayList<Product>();
        this.qtyList = new ArrayList<Integer>();
        this.spent = sp;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public ArrayList<Product> getCartList() {
        return cartList;
    }
    
    public ArrayList<Integer> getQtyList() {
        return qtyList;
    }
    
    public void setArrayList(ArrayList<Product> plist) {
        this.cartList = plist;
    }
    
    public float getSpent() {
        return this.spent;
    }
    
    public void setSpent(float f) {
        this.spent = f;
    }
    
    public void addToCart(Product p, Integer a) {
        int f = 0;
        for (int i =0; i<cartList.size();i++) {
            if (cartList.get(i).getId()==p.getId()) {
                int q = qtyList.get(i);
                qtyList.set(i, q+a);
                f=1;
                break;
            }
        }
        if (f==0) {
            this.cartList.add(p);
            this.qtyList.add(a);
        }
    }
    
    public void clearCart() {
        this.cartList.clear();
        this.qtyList.clear();
    }
    
    @Override
    public int compareTo(Customer customer) {
        return ( this.getSpent() > customer.getSpent() ? -1 :
                ( this.getSpent()==customer.getSpent()? 0 : 1 ));
        
    }
}