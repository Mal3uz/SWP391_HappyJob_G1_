/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Transaction {
  private int transactionID;
    private int wSenderID;
    private int wReceiverID;
    private int price;
    private String transactionType;
    private int orderID;
    private String status;
    private String transactionDate;

    public Transaction() {
    }

    public Transaction(int transactionID, int wSenderID, int wReceiverID, int price, String transactionType, int orderID, String status, String transactionDate) {
        this.transactionID = transactionID;
        this.wSenderID = wSenderID;
        this.wReceiverID = wReceiverID;
        this.price = price;
        this.transactionType = transactionType;
        this.orderID = orderID;
        this.status = status;
        this.transactionDate = transactionDate;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getwSenderID() {
        return wSenderID;
    }

    public void setwSenderID(int wSenderID) {
        this.wSenderID = wSenderID;
    }

    public int getwReceiverID() {
        return wReceiverID;
    }

    public void setwReceiverID(int wReceiverID) {
        this.wReceiverID = wReceiverID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", wSenderID=" + wSenderID + ", wReceiverID=" + wReceiverID + ", price=" + price + ", transactionType=" + transactionType + ", orderID=" + orderID + ", status=" + status + ", transactionDate=" + transactionDate + '}';
    }

 
    
}
