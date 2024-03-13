/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Product {
    private int productID;
    private int transactionID;
    private int orderID;
    private int accountID;
    private String urlProduct;
    private String timestamp;
    private String status;
    private String reason;

    public Product() {
    }

    public Product(int productID, int transactionID, int orderID, int accountID, String urlProduct, String timestamp, String status, String reason) {
        this.productID = productID;
        this.transactionID = transactionID;
        this.orderID = orderID;
        this.accountID = accountID;
        this.urlProduct = urlProduct;
        this.timestamp = timestamp;
        this.status = status;
        this.reason = reason;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUrlProduct() {
        return urlProduct;
    }

    public void setUrlProduct(String urlProduct) {
        this.urlProduct = urlProduct;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", transactionID=" + transactionID + ", orderID=" + orderID + ", accountID=" + accountID + ", urlProduct=" + urlProduct + ", timestamp=" + timestamp + ", status=" + status + ", reason=" + reason + '}';
    }

    
    
}
