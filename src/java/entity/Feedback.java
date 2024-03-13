/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Feedback {
    private int feedbackID;
    private String content;
    private int accountID;
    private int talentID;
    private String Timestamp;

    public Feedback() {
    }

    public Feedback(int feedbackID, String content, int accountID, int talentID, String Timestamp) {
        this.feedbackID = feedbackID;
        this.content = content;
        this.accountID = accountID;
        this.talentID = talentID;
        this.Timestamp = Timestamp;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackID=" + feedbackID + ", content=" + content + ", accountID=" + accountID + ", talentID=" + talentID + ", Timestamp=" + Timestamp + '}';
    }
    
    

}
