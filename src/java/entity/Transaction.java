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
    private int walletID;
    private int totalPrice;
    private int orderID;
    private String status;
    private String transactionDate;

    public Transaction() {
    }

    public Transaction(int transactionID, int walletID, int totalPrice, int orderID, String status, String transactionDate) {
        this.transactionID = transactionID;
        this.walletID = walletID;
        this.totalPrice = totalPrice;
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

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
        return "Transaction{" + "transactionID=" + transactionID + ", walletID=" + walletID + ", totalPrice=" + totalPrice + ", orderID=" + orderID + ", status=" + status + ", transactionDate=" + transactionDate + '}';
    }

   
  
    
    
}
