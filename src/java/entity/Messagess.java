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
     private int ReceiverID;
     private String timestamp;
     private String Content;

    public Messagess() {
    }

    public Messagess(int messageID, int senderID, int ReceiverID, String timestamp, String Content) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.ReceiverID = ReceiverID;
        this.timestamp = timestamp;
        this.Content = Content;
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
        return ReceiverID;
    }

    public void setReceiverID(int ReceiverID) {
        this.ReceiverID = ReceiverID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    @Override
    public String toString() {
        return "Messagess{" + "messageID=" + messageID + ", senderID=" + senderID + ", ReceiverID=" + ReceiverID + ", timestamp=" + timestamp + ", Content=" + Content + '}';
    }
    
     
    
}
