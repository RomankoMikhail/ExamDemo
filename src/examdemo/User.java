/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examdemo;

import java.util.ArrayList;

/**
 *
 * @author roman
 */
public class User {
    private String username;
    private String fullname;
    private String password;
    private int id;
    private int type;
    
    public User() {
        username = fullname = password = "";
        id = 0;
        type = 0;
    }
    
    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }
    
    public User(String id, String fullname, String username, String password, String type) {
        formDataFromStrings(id, fullname, username, password, type);
    }
    
    public void formDataFromStrings(String id, String fullname, String username, String password, String type) {
        this.id = Integer.parseInt(id);
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        
        if(type.equals("Заказчик")) {
            this.type = 1;
        }
        
        if(type.equals("Менеджер")) {
            this.type = 2;
        }
        
        if(type.equals("Директор")) {
            this.type = 3;
        }
        
        if(type.equals("Кладовщик")) {
            this.type = 4;
        }
    }
}
