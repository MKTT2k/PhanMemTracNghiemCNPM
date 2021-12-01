/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Account {
        String UserName, Password, Full_Name, Class_Name , Phone;
    boolean Role;

    public Account(String UserName, String Password, String Full_Name, String Class_Name, String Phone, boolean Role) {
        this.UserName = UserName;
        this.Password = Password;
        this.Full_Name = Full_Name;
        this.Class_Name = Class_Name;
        this.Phone = Phone;
        this.Role = Role;
    }

    public Account(String UserName, String Full_Name, String Class_Name, String Phone) {
        this.UserName = UserName;
        this.Full_Name = Full_Name;
        this.Class_Name = Class_Name;
        this.Phone = Phone;
    }

    public Account(String UserName, String Password, String Full_Name, String Class_Name, String Phone) {
        this.UserName = UserName;
        this.Password = Password;
        this.Full_Name = Full_Name;
        this.Class_Name = Class_Name;
        this.Phone = Phone;
    }
    

    public Account() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public String getClass_Name() {
        return Class_Name;
    }

    public void setClass_Name(String Class_Name) {
        this.Class_Name = Class_Name;
    }

    

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean Role) {
        this.Role = Role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        return true;
    }

    
}
