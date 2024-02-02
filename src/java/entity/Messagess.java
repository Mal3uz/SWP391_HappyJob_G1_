/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Messagess {
     private int messageID ;
     private int senderID ;
     private int receiverID;
     private String timestamp;
     private String content;

    public Messagess() {
    }

    public Messagess(int messageID, int senderID, int receiverID, String timestamp, String content) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Messagess{" + "messageID=" + messageID + ", senderID=" + senderID + ", receiverID=" + receiverID + ", timestamp=" + timestamp + ", content=" + content + '}';
    }

     
    
}
