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
    private int AccountID;
    private String Password;
    private String Email;
    private String Name;
    private Date Dob;
    private String Gender;
    private String SecurityQuestion;
    private int RoleID;
    private String Status;

    public Account() {
    }

    public Account(int AccountID, String Password, String Email, String Name, Date Dob, String Gender, String SecurityQuestion, int RoleID, String Status) {
        this.AccountID = AccountID;
        this.Password = Password;
        this.Email = Email;
        this.Name = Name;
        this.Dob = Dob;
        this.Gender = Gender;
        this.SecurityQuestion = SecurityQuestion;
        this.RoleID = RoleID;
        this.Status = Status;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        this.SecurityQuestion = SecurityQuestion;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getStatus() {
         if (Status == "1") {
            return "Active";
        } else if (Status == "2") {
            return "Locked";
        } else if (Status == "3") {
            return "Gmail Login";
        } else {
            return "Unverified";
        }
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
