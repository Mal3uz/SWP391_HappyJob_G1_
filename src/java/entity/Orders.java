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
    private int totalPrice;
    private int deposit;
    private String timestamp;
    private String status;

    public Orders() {
    }

    public Orders(int orderID, int talentID, int accountID, int totalPrice, int deposit, String timestamp, String status) {
        this.orderID = orderID;
        this.talentID = talentID;
        this.accountID = accountID;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.timestamp = timestamp;
        this.status = status;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
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

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", talentID=" + talentID + ", accountID=" + accountID + ", totalPrice=" + totalPrice + ", deposit=" + deposit + ", timestamp=" + timestamp + ", status=" + status + '}';
    }



}
