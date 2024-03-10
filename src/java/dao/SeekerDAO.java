/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Feedback;
import entity.Rating;
import entity.ServicePackage;
import entity.Talent;
import entity.Transaction;
import entity.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SeekerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //talent
    public List<Talent> getListTalentByCategoryId(String categoryId) {
        List<Talent> listT = new ArrayList<>();
        String query = "select * from Talent t\n"
                + "join TalentCategory tc on t.TalentID = tc.TalentID\n"
                + "join Category c on tc.CategoryID = c.CategoryID\n"
                + "where c.CategoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, categoryId);
            rs = ps.executeQuery();

            while (rs.next()) {
                listT.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));

            }
        } catch (Exception e) {
        }

        return listT;

    }

    public Talent getTalentByTalentId(String talentId) {
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
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Talent getTalentByTransactionId(String transactionId) {
        String query = "select * from Talent t\n"
                + "join Orders o on t.TalentID = o.TalentID\n"
                + "join Transactions trs on trs.OrderID = o.OrderID\n"
                + "where trs.TransactionID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, transactionId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }

        return null;
    }

    //account
    public Account getAccountById(int id) {
        String query = "select * from Account\n"
                + "where AccountID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account getAccountByTalentId(String talentId) {
        String query = "select * from Account a\n"
                + "join Talent t on a.AccountID = t.AccountID\n"
                + "where t.TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account getAccountByFeedbackId(String feedbackId) {
        String query = "select * from Account a\n"
                + "join Feedback f on a.AccountID = f.AccountID\n"
                + "where f.FeedbackID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, feedbackId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void UpdateAccount(String name, String gender, String dob, String imgurl, int accountID) {
        String query = "UPDATE Account SET [Name] = ?, Dob = ?, Gender = ?, Img = ?  WHERE AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, gender);
            ps.setString(4, imgurl);
            ps.setInt(5, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //servicepackage
    public ServicePackage BasicPackageByTalentId(String talentId) {
        String query = "select * from ServicePackage s\n"
                + "join Talent t on s.TalentID = t.TalentID\n"
                + "where t.TalentID = ? and Type = 'Basic'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new ServicePackage(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }

        return null;
    }

    //feedback
    public List<Feedback> getListFeedbackByTalentId(String talentId) {
        List<Feedback> listF = new ArrayList<>();
        String query = "select * from Feedback\n"
                + "where TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                listF.add(new Feedback(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }
        } catch (Exception e) {
        }

        return listF;

    }

    public int getNumberFeedbackByTalentId(String talentId) {
        String query = "select count(*) from Feedback\n"
                + "where TalentID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Feedback checkFeedback(int accountId, int talentId) {
        String query = "select * from Feedback\n"
                + "where AccountID = ? and TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);
            ps.setInt(2, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Feedback(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Rating checkRating(int accountId, int talentId) {
        String query = "select * from Rating \n"
                + "where AccountID = ? and TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);
            ps.setInt(2, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Rating(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void InsertFeedback(String content, int accountID, int talentID, String time) {
        String query = "INSERT INTO Feedback (Content, AccountID, TalentID, [Timestamp])\n"
                + "VALUES (?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setInt(2, accountID);
            ps.setInt(3, talentID);
            ps.setString(4, time);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void InsertRating(int talentID, int score, int accountID) {
        String query = "INSERT INTO Rating ( TalentID, Score, AccountID)\n"
                + "VALUES (?, ?, ?);;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, talentID);
            ps.setInt(2, score);
            ps.setInt(3, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UpdateFeedback(String content, String time, int feedbackId) {
        String query = "UPDATE Feedback SET Content = ?, [Timestamp] = ?\n"
                + " WHERE FeedbackID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setString(2, time);
            ps.setInt(3, feedbackId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateRating(int score, int ratingId) {
        String query = "UPDATE Rating SET Score = ? WHERE RatingID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, score);
            ps.setInt(2, ratingId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //transaction
    public List<Transaction> getListTransaction(int accountID, int talentID) {
        List<Transaction> listF = new ArrayList<>();
        String query = "select * from Transactions trs\n"
                + "join Orders o on trs.OrderID = o.OrderID\n"
                + "where o.AccountID = ? and o.TalentID = ? and trs.Status = 'Completed'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, talentID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listF.add(new  Transaction(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
        }

        return listF;

    }

    public List<Transaction> getListTransactionByAccountId(int accountID) {
        List<Transaction> listF = new ArrayList<>();
        String query = "select * from Transactions \n"
                + "where WSeekerID = ?  and (Status = 'refunded' or Status = 'Completed')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listF.add(new  Transaction(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
        }

        return listF;

    }

    //wallet
    public Wallet getWalletByAccountId(int accountID) {
        String query = "select * from Wallet\n"
                + "where AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Wallet(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static void main(String[] args) {
        SeekerDAO dao = new SeekerDAO();
        List<Talent> b = dao.getListTalentByCategoryId("1");
      
       
        Talent w = dao.getTalentByTransactionId("11");
        System.out.println(w);
    }
}
