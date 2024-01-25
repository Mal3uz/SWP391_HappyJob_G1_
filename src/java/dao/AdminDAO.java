/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Notifications;
import entity.Talent;
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

    //a1
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
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));

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

    public Account getAccountByTalentId(String talentId) {
        String query = "select * from Account a\n"
                + "join Talent t on a.AccountID = t.AccountID\n"
                + "where t.TalentID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }

        return null;
    }

    //t1
    public List<Talent> getListAllTalent() {
        List<Talent> listT = new ArrayList<>();
        String query = "select * from Talent\n"
                + "where Status = 'Pending'";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listT.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
        }

        return listT;

    }

    public Talent getTalentById(String talentId) {
        String query = "select * from Talent \n"
                + "where TalentID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void acceptTalent(String talentId) {
        String query = "UPDATE Talent\n"
                + "SET Status = 'Active'\n"
                + "WHERE TalentID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void rejectTalent(String talentId, String reason) {
        String query = "UPDATE Talent\n"
                + "SET Status = 'Reject', Reason = ?\n"
                + "WHERE TalentID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, reason);
            ps.setString(2, talentId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //n1
     public List<Notifications> getListNotificationses() {
        List<Notifications> listN = new ArrayList<>();
        String query = "select * from Notifications";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                rs.getString(6)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        List<Talent> a = dao.getListAllTalent();
        for (Talent account : a) {
            System.out.println(account);
        }
    }
}
