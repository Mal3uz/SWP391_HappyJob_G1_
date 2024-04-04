/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Feedback;
import entity.Orders;
import entity.Rating;
import entity.ServicePackage;
import entity.Talent;
import entity.Transaction;
import entity.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                + "where c.CategoryID = ? and t.Status = 'Active'";
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

    public List<Talent> pagingActiveTalentCate(int index, String cateid) {
        List<Talent> list = new ArrayList<>();
        String sql = "select * from Talent t\n"
                + "join TalentCategory tc on t.TalentID = tc.TalentID\n"
                + "join Category c on tc.CategoryID = c.CategoryID\n"
                + "where c.CategoryID = ? and t.Status = 'Active'\n"
                + "order by c.CategoryID\n"
                + "OFFSET ? rows fetch next 4 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cateid);
            ps.setInt(2, (index - 1) * 4);

            rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Talent(rs.getInt(1),
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
        return list;
    }

    public int getNumberTalentByCate(String cateid) {
        String sql = "select count(*) from Talent t\n"
                + "join TalentCategory tc on t.TalentID = tc.TalentID\n"
                + "join Category c on tc.CategoryID = c.CategoryID\n"
                + "where c.CategoryID = ? and t.Status = 'Active'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
             ps.setString(1, cateid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
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

    //update profile
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
    public Orders getOrderByTAid(int accountID, int talentID) {
        String query = "select * from Orders o\n"
                + "join Account a on o.AccountID = a.AccountID\n"
                + "join Talent t on o.TalentID = t.TalentID\n"
                + "where o.Status = 'Completed' and o.AccountID = ? and o.TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, talentID);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (Exception e) {
        }

        return null;

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

    public List<Transaction> getListTransactionByAId(int accountID) {
        List<Transaction> listtTransactions = new ArrayList<>();
        String query = "SELECT *\n"
                + "FROM Transactions trs\n"
                + "JOIN Wallet w ON ((trs.WSenderID = w.WalletID) OR (trs.WReceiverID = w.WalletID))\n"
                + "WHERE w.WalletID = ?\n"
                + "ORDER BY trs.transactiondate ASC;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listtTransactions.add(new Transaction(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
        }

        return listtTransactions;
    }

    public void requestAddMoney(int accountId, int price, int orderid, String date) {

        String query = "INSERT INTO Transactions (wSenderID, wReceiverID, price, transactionType, orderID, status, transactionDate)\n"
                + "VALUES (?, 1, ?, 'Add', ?, 'Pending', ?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Set parameters
            ps.setInt(1, accountId);
            ps.setInt(2, price);
            ps.setInt(3, orderid);
            ps.setString(4, date);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void requestWidthdraw(int accountId, int price, int orderid, String date) {

        String query = "INSERT INTO Transactions (wSenderID, wReceiverID, price, transactionType, orderID, status, transactionDate)\n"
                + "VALUES (?, 1, ?, 'Minus', ?, 'Pending', ?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Set parameters
            ps.setInt(1, accountId);
            ps.setInt(2, price);
            ps.setInt(3, orderid);
            ps.setString(4, date);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public int createOrderWithType(int accountId, String date, String type) {
        String query = "INSERT INTO Orders(AccountID, Timestamp, Status, OrderType) "
                + "VALUES (?, ?, 'Processing', ?)";
        int orderId = -1;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            ps.setInt(1, accountId);
            ps.setString(2, date);
            ps.setString(3, type);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
        } catch (Exception e) {
            // Handle exception
        }
        return orderId;
    }

    public static void main(String[] args) {
        SeekerDAO dao = new SeekerDAO();
        List<Talent> b = dao.getListTalentByCategoryId("1");
        List<Transaction> trans = dao.getListTransactionByAId(10);
        for (Transaction tran : trans) {
            System.out.println(tran);
        }
        System.out.println(dao.getListTransactionByAId(6));
    }
}
