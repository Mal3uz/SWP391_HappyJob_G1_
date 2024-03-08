/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class WalletDAO {
     public int getBalance(int accId) throws Exception {
        String query = "select a.Balance from Wallet a inner join Account b on a.AccountID = b.AccountID where b.AccountID = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, accId);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                return rs.getInt("Balance");
            } else {
                // Handle case when no row is found for the given PacketID
                return -1; // Or throw an exception, return a default value, etc.
            }
        }
    } catch (SQLException ex) {
        // Handle SQLException
        ex.printStackTrace(); // Or log the exception
        return -1; // Return a default value or throw an exception
    }
        
    }
     
      public void updateNewBalance(int  accId, int newBalance) throws SQLException, Exception {
        String sql = "UPDATE Wallet SET Balance = ? WHERE  AccountID = ?";
        
        try (Connection con = new DBContext().getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, newBalance);
            statement.setInt(2, accId);
            
            int rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated != 1) {
                throw new SQLException("Failed to update balance for WalletID: " + accId);
            }
        }
    }
     
         public static void main(String[] args) throws Exception {
        WalletDAO aO = new WalletDAO();
      aO.updateNewBalance(13, 10000);
    }
}
