/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Talent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account getAccountById(int accountID) {
        String sql = "SELECT * FROM account where accountID = ?;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
     
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getNString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        Account a = ad.getAccountById(1);
        System.out.println(a);
    }
}
