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
public class Talent {
    private int TalentID;
    private String Title;
    private String  Description;
    private Date CreatedAt;
    private int AccountID;
    private String Status;
    private String img;

    public Talent() {
    }

    public Talent(int TalentID, String Title, String Description, Date CreatedAt, int AccountID, String Status, String img) {
        this.TalentID = TalentID;
        this.Title = Title;
        this.Description = Description;
        this.CreatedAt = CreatedAt;
        this.AccountID = AccountID;
        this.Status = Status;
        this.img = img;
    }

    
    
    public int getTalentID() {
        return TalentID;
    }

    public void setTalentID(int TalentID) {
        this.TalentID = TalentID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
