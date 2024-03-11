/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Rating {
    private int ratingID;
    private int talentID;
    private int score;
    private int accountID;

    public Rating() {
    }

    public Rating(int ratingID, int talentID, int score, int accountID) {
        this.ratingID = ratingID;
        this.talentID = talentID;
        this.score = score;
        this.accountID = accountID;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getTalentID() {
        return talentID;
    }

    public void setTalentID(int talentID) {
        this.talentID = talentID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Rating{" + "ratingID=" + ratingID + ", talentID=" + talentID + ", score=" + score + ", accountID=" + accountID + '}';
    }

   
    
    
}
