/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Notifications {
    private int notificationID;
    private int accountID ;
    private int talentID;
    private String message;
    private String createdAt;

    public Notifications() {
    }

    public Notifications(int notificationID, int accountID, int talentID, String message, String createdAt) {
        this.notificationID = notificationID;
        this.accountID = accountID;
        this.talentID = talentID;
        this.message = message;
        this.createdAt = createdAt;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getTalentID() {
        return talentID;
    }

    public void setTalentID(int talentID) {
        this.talentID = talentID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notifications{" + "notificationID=" + notificationID + ", accountID=" + accountID + ", talentID=" + talentID + ", message=" + message + ", createdAt=" + createdAt + '}';
    }

    
    
}
