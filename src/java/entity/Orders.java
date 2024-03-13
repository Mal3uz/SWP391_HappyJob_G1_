/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Orders {

    private int orderID;
    private int talentID;
    private int accountID;
    private String timestamp;
    private String status;
    private String orderType;

    public Orders() {
    }

    public Orders(int orderID, int talentID, int accountID, String timestamp, String status, String orderType) {
        this.orderID = orderID;
        this.talentID = talentID;
        this.accountID = accountID;
        this.timestamp = timestamp;
        this.status = status;
        this.orderType = orderType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTalentID() {
        return talentID;
    }

    public void setTalentID(int talentID) {
        this.talentID = talentID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", talentID=" + talentID + ", accountID=" + accountID + ", timestamp=" + timestamp + ", status=" + status + ", orderType=" + orderType + '}';
    }
    
    

}
