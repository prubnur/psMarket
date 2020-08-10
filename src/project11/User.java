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
public class User {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    
    public User(int uid, String uname, String uemail, String uusername, String upassword) {
        this.id = uid;
        this.name = uname;
        this.email = uemail;
        this.username = uusername;
        this.password = upassword;
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
}
