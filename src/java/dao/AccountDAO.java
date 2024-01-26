/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Talent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAccountById(int id) {
        try {
            String query = "select * from Account where AccountID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String gender = rs.getNString("gender");
                String status = rs.getString("status");
                Account a = new Account();
                a.setAccountID(id);
                a.setEmail(email);
                a.setName(name);
                a.setDob(dob.toString());
                a.setGender(gender);
                a.setStatus(status);
                return a;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account updateAccount(Account account) {
        String query = "update Account set email = ?, name = ?, dob = ?, gender = ? where AccountID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getName());
            ps.setDate(3, Date.valueOf(account.getDob()));
            ps.setNString(4, account.getGender());
            ps.setInt(5, account.getAccountID());
            int k = ps.executeUpdate();
            if (k > 0)
                return account;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Account a = dao.getAccountById(1);
        a.setName("ok1");
        dao.updateAccount(a);
        System.out.println(a);
    }
}
