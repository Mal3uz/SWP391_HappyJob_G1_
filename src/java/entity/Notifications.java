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
    private int recipientID;
    private String message;
    private int status;
    private String createdAt;

    public Notifications() {
    }

    public Notifications(int notificationID, int recipientID, String message, int status, String createdAt) {
        this.notificationID = notificationID;
        this.recipientID = recipientID;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notifications{" + "notificationID=" + notificationID + ", recipientID=" + recipientID + ", message=" + message + ", status=" + status + ", createdAt=" + createdAt + '}';
    }

   


}
