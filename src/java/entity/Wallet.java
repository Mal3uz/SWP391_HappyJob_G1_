/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Wallet {
    private int walletID;
    private int accountID;
    private int Balance;

    public Wallet() {
    }

    public Wallet(int walletID, int accountID, int Balance) {
        this.walletID = walletID;
        this.accountID = accountID;
        this.Balance = Balance;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    @Override
    public String toString() {
        return "Wallet{" + "walletID=" + walletID + ", accountID=" + accountID + ", Balance=" + Balance + '}';
    }
    
    
}
