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
    private int wSeekerID;
    private int wProviderID;
    private int seekerPrice;
    private int providerPrice;
    private int orderID;
    private String status;
    private String transactionDate;

    public Transaction() {
    }

    public Transaction(int transactionID, int wSeekerID, int wProviderID, int seekerPrice, int providerPrice, int orderID, String status, String transactionDate) {
        this.transactionID = transactionID;
        this.wSeekerID = wSeekerID;
        this.wProviderID = wProviderID;
        this.seekerPrice = seekerPrice;
        this.providerPrice = providerPrice;
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

    public int getwSeekerID() {
        return wSeekerID;
    }

    public void setwSeekerID(int wSeekerID) {
        this.wSeekerID = wSeekerID;
    }

    public int getwProviderID() {
        return wProviderID;
    }

    public void setwProviderID(int wProviderID) {
        this.wProviderID = wProviderID;
    }

    public int getSeekerPrice() {
        return seekerPrice;
    }

    public void setSeekerPrice(int seekerPrice) {
        this.seekerPrice = seekerPrice;
    }

    public int getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(int providerPrice) {
        this.providerPrice = providerPrice;
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
        return "Transaction{" + "transactionID=" + transactionID + ", wSeekerID=" + wSeekerID + ", wProviderID=" + wProviderID + ", seekerPrice=" + seekerPrice + ", providerPrice=" + providerPrice + ", orderID=" + orderID + ", status=" + status + ", transactionDate=" + transactionDate + '}';
    }

   
    
}
