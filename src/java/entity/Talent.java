/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Talent {
    private int talentID;
    private String title;
    private String img;
    private String  description;
    private String createdAt;
    private int accountID;
    private String status;

    public Talent() {
    }

    public Talent(int talentID, String title, String img, String description, String createdAt, int accountID, String status) {
        this.talentID = talentID;
        this.title = title;
        this.img = img;
        this.description = description;
        this.createdAt = createdAt;
        this.accountID = accountID;
        this.status = status;
    }

    public int getTalentID() {
        return talentID;
    }

    public void setTalentID(int talentID) {
        this.talentID = talentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Talent{" + "talentID=" + talentID + ", title=" + title + ", img=" + img + ", description=" + description + ", createdAt=" + createdAt + ", accountID=" + accountID + ", status=" + status + '}';
    }
    

  
}
