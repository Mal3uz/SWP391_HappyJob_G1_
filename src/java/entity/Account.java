package entity;

import java.sql.Date;

public class Account {
    private int accountID;
    private String password;
    private String email;
    private String name;
    private String dob;
    private String gender;
    private String img; // New field for image URL
    private int roleID;
    private String status;
    private String verificationCode;

    public Account() {
        
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Account(int accountID, String password, String email, String name, String dob, String gender, String img, int roleID, String status, String verificationCode) {
        this.accountID = accountID;
        this.password = password;
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.img = img;
        this.roleID = roleID;
        this.status = status;
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", password=" + password + ", email=" + email + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", img=" + img + ", roleID=" + roleID + ", status=" + status + ", verificationCode=" + verificationCode + '}';
    }
    
    }

