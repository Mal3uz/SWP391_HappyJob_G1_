/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Account {
    private int accountID;
    private String password;
    private String email;
    private String name;
    private String dob;
    private String verifycode;
    private String availableTime;
    private String gender;
   // private String SecurityQuestion;
    private int roleID;
    private String status;

    public Account() {
    }

    public Account(int accountID, String password, String email, String name, String dob, String verifycode, String availableTime, String gender, int roleID, String status) {
        this.accountID = accountID;
        this.password = password;
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.verifycode = verifycode;
        this.availableTime = availableTime;
        this.gender = gender;
        this.roleID = roleID;
        this.status = status;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", password=" + password + ", email=" + email + ", name=" + name + ", dob=" + dob + ", verifycode=" + verifycode + ", availableTime=" + availableTime + ", gender=" + gender + ", roleID=" + roleID + ", status=" + status + '}';
    }


   
    
    
}
