/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Account> getListAllAccount() {
        List<Account> listA = new ArrayList<>();
        String query = "select * from Account";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listA.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
        }

        return listA;

    }

    public void lockAccount(String accountID) {
        String query = "UPDATE Account\n"
                + "SET Status = 'Lock'\n"
                + "WHERE AccountID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
      public void unlockAccount(String accountID) {
        String query = "UPDATE Account\n"
                + "SET Status = 'Active'\n"
                + "WHERE AccountID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        List<Account> a = dao.getListAllAccount();
        for (Account account : a) {
            System.out.println(account);
        }
    }
}
