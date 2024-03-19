package dao;

import entity.Account;
import entity.Messagess;
import entity.Notifications;
import entity.Orders;
import entity.Product;
import entity.ServicePackage;
import entity.Talent;
import entity.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //a1
    public List<Account> getListAllAccount() {
        List<Account> listA = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listA.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (rs, ps, conn) in a finally block
            // Handle exceptions properly
        }
        return listA;
    }

    public Map<Account, Integer> getTopAccountWithPurchaseCount() {
        Map<Account, Integer> accountPurchaseCountMap = new HashMap<>();
        String query = "SELECT TOP 5 A.Img, A.[Name], A.Email, A.Gender, COUNT(*) AS PurchaseCount\n"
                + " from Orders O \n"
                + "JOIN Account A ON O.AccountID = A.AccountID\n"
                + "WHERE O.[Status] = 'Finish'\n"
                + "GROUP BY A.Img, A.[Name], A.Email, A.Gender\n"
                + "ORDER BY PurchaseCount DESC";
        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account(
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("img"));

                int purchaseCount = rs.getInt("PurchaseCount");

                accountPurchaseCountMap.put(account, purchaseCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountPurchaseCountMap;
    }

    public void lockAccount(String accountID) {
        String query = "UPDATE Account SET Status = 'Lock' WHERE AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
    }

    public void unlockAccount(String accountID) {
        String query = "UPDATE Account\n"
                + "SET Status = 'Active'\n"
                + "WHERE AccountID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
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

    public Account getAccountByProductId(String productId) {
        String query = "select * from Account a\n"
                + "join Product p on a.AccountID = p.AccountID\n"
                + "where p.ProductID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
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

    public Account getAccountByWalletId(String walletId) {
        String query = "select * from Account a\n"
                + "join Wallet w on a.AccountID = w.AccountID\n"
                + "where w.WalletID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, walletId);
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

    public Account getAccountByTransactionId(String transactionId) {
        String query = "select * from Account a\n"
                + "join Wallet w on a.AccountID = w.AccountID\n"
                + "join Transactions trs on trs.WSenderID = w.WalletID\n"
                + " where trs.TransactionID = ?  ";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, transactionId);
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

    public Account getAccountByOrderId(String orderId) {
        String query = "select * from Account a\n"
                + "join Orders o on a.AccountID = o.AccountID\n"
                + "where o.OrderID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, orderId);
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

    public List<Account> getListAccountBySenderID(int SenderId) {
        List<Account> listA = new ArrayList<>();
        String query = "WITH SentMessages AS (\n"
                + "    SELECT DISTINCT M.SenderID AS AccountID, MAX(M.[Timestamp]) AS LatestMessageTime\n"
                + "    FROM Messagess M\n"
                + "    WHERE M.ReceiverID = ?\n"
                + "    GROUP BY M.SenderID\n"
                + "),\n"
                + "ReceivedMessages AS (\n"
                + "    SELECT DISTINCT M.ReceiverID AS AccountID, MAX(M.[Timestamp]) AS LatestMessageTime\n"
                + "    FROM Messagess M\n"
                + "    WHERE M.SenderID = ?\n"
                + "    GROUP BY M.ReceiverID\n"
                + "),\n"
                + "Combined AS (\n"
                + "    SELECT AccountID, MAX(LatestMessageTime) AS LatestMessageTime FROM (\n"
                + "        SELECT AccountID, LatestMessageTime FROM SentMessages\n"
                + "        UNION ALL\n"
                + "        SELECT AccountID, LatestMessageTime FROM ReceivedMessages\n"
                + "    ) AS SubQuery\n"
                + "    GROUP BY AccountID\n"
                + ")\n"
                + "SELECT A.*\n"
                + "FROM Account A\n"
                + "JOIN Combined C ON A.AccountID = C.AccountID\n"
                + "ORDER BY C.LatestMessageTime DESC;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, SenderId);
            ps.setInt(2, SenderId);
            rs = ps.executeQuery();

            while (rs.next()) {
                listA.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));

            }
        } catch (Exception e) {
        }

        return listA;
    }

    public int getTotalAccount() {
        String query = "select count(*) from Account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getNumberAccountByStatus(String status) {
        String query = "select count(*) from Account\n"
                + "where Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Account> pagingAccount(int index) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account\n"
                + "order by AccountID\n"
                + "OFFSET ? rows fetch next 10 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //t1
    public List<Talent> getListPendingTalent() {
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
                        rs.getString(8),
                        rs.getInt(9)));

            }
        } catch (Exception e) {
        }

        return listT;

    }

    public List<Talent> getListActiveTalent() {
        List<Talent> listT = new ArrayList<>();
        String query = "select * from Talent\n"
                + "where Status = 'Active'\n"
                + "order by CreatedAt desc";
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
                        rs.getString(8),
                        rs.getInt(9)));

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
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void acceptTalent(String talentId, String approvedBy) {
        String query = "UPDATE Talent\n"
                + "SET Status = 'Active', ApprovedBy = ?\n"
                + "WHERE TalentID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, approvedBy);
            ps.setString(2, talentId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void rejectTalent(String talentId, String reason, String approvedBy) {
        String query = "UPDATE Talent\n"
                + "SET Status = 'Reject', Reason = ?,ApprovedBy = ? \n"
                + "WHERE TalentID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, reason);
            ps.setString(2, approvedBy);
            ps.setString(3, talentId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getNumberTalentByStatus(String Status) {
        String query = "select count(*) from Talent\n"
                + "where Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Status);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Talent> pagingPendingTalent(int index) {
        List<Talent> list = new ArrayList<>();
        String query = "select * from Talent\n"
                + "where Status = 'Pending'\n"
                + "order by TalentID\n"
                + "OFFSET ? rows fetch next 12 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 12);
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

    public int getActiveTalent() {
        String query = "select count(*) from Talent\n"
                + "where Status = 'Active'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Talent> pagingActiveTalent(int index) {
        List<Talent> list = new ArrayList<>();
        String query = "select * from Talent\n"
                + "where Status = 'Active'\n"
                + "order by TalentID\n"
                + "OFFSET ? rows fetch next 12 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 12);
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

    public Map<Talent, Integer> getTopTalentWithAmountSold() {
        Map<Talent, Integer> accountPurchaseCountMap = new HashMap<>();
        String query = "SELECT TOP 5 T.TalentID, T.Title, T.CreatedAt, COUNT(*) AS AmountSold\n"
                + " from Orders O \n"
                + " JOIN  Talent T ON O.TalentID = T.TalentID\n"
                + "JOIN Account A ON T.AccountID = A.AccountID\n"
                + "WHERE O.[Status] = 'Finish'\n"
                + "GROUP BY  T.TalentID, T.Title, T.CreatedAt\n"
                + "ORDER BY AmountSold DESC";
        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Talent talent = new Talent(rs.getInt("talentID"),
                        rs.getString("title"),
                        rs.getString("createdAt"));

                int AmountSold = rs.getInt("AmountSold");

                accountPurchaseCountMap.put(talent, AmountSold);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountPurchaseCountMap;
    }

    //sp1
    public List<ServicePackage> ServicePackagesByTalentId(String talentId) {
        List<ServicePackage> list = new ArrayList<>();
        String query = "select * from ServicePackage s\n"
                + "join Talent t on s.TalentID = t.TalentID\n"
                + "where t.TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ServicePackage(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ServicePackage> ServicePackagesByOrderId(String orderId) {
        List<ServicePackage> list = new ArrayList<>();
        String query = "select * from ServicePackage sp\n"
                + "join OrderDetail od on sp.PacketID = od.PacketID\n"
                + "join Orders o on od.OrderID = o.OrderID\n"
                + "where o.OrderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ServicePackage(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ServicePackage BasicPackageById(String talentId) {
        String query = "select * from ServicePackage s\n"
                + "join Talent t on s.TalentID = t.TalentID\n"
                + "where t.TalentID = ? and Type = 'Basic'";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
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

    //s1
    public List<Account> searchByMail(String email) {
        List<Account> list = new ArrayList<>();

        String query = "select * from Account\n"
                + "where Email like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + email + "%"); // Truyền tham số vào câu truy vấn
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //n1
    public List<Notifications> getListNotificationsesByAccount(String accountID) {
        List<Notifications> listN = new ArrayList<>();
        String query = "select * from Notifications\n"
                + "where [RecipientID] = ?\n"
                + "order by CreatedAt desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public List<Notifications> getNewNotificationsesByAccount(int accountID) {
        List<Notifications> listN = new ArrayList<>();
        String query = "SELECT TOP 3 *\n"
                + "from Notifications\n"
                + "where [RecipientID] = ?\n"
                + "order by CreatedAt desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public int getNumberNewNotificationses(int accountID) {
        String query = "SELECT COUNT(*)\n"
                + "FROM Notifications\n"
                + "where [RecipientID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;

    }

    public void readAll(String accountID) {
        String query = "UPDATE Notifications\n"
                + "SET Status = 1\n"
                + "where AccountID = ? ";

        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void insertNotificationApprovel(int recipientId, String mess, int status, String createAt) {
        String query = "INSERT INTO Notifications ( RecipientID, [Message],Status,CreatedAt)\n"
                + "VALUES (?,?,?,?);";

        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, recipientId);
            ps.setString(2, mess);
            ps.setInt(3, status);
            ps.setString(4, createAt);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    //m1
    public List<Messagess> getMessBySendReceiver(int SenderId, int ReceiverId) {
        List<Messagess> listM = new ArrayList<>();
        String query = "select * from Messagess\n"
                + "WHERE SenderID = ? and ReceiverID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, SenderId);
            ps.setInt(2, ReceiverId);
            rs = ps.executeQuery();

            while (rs.next()) {
                listM.add(new Messagess(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));

            }
        } catch (Exception e) {
        }

        return listM;

    }

    public void InsertMessage(int sendId, int receiverId, String date, String content) {

        String query = "INSERT INTO Messagess (SenderID, ReceiverID, Timestamp,Content)\n"
                + "VALUES (?,?,?,?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            // Set parameters
            ps.setInt(1, sendId);
            ps.setInt(2, receiverId);
            ps.setString(3, date);
            ps.setString(4, content);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Messagess getLastMessageThroughTwoFriendId(int SenderId, int ReceiverId) {
        String query = "select top 1 * from Messagess where (SenderID = ? and ReceiverID= ?)\n"
                + "order by Timestamp desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, SenderId);
            ps.setInt(2, ReceiverId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Messagess(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));

            }
        } catch (Exception e) {
        }

        return null;

    }

    //tr1
    public List<Transaction> getListTransactions() {
        List<Transaction> listT = new ArrayList<>();
        String query = "select * from Transactions";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listT.add(new Transaction(rs.getInt(1),
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

        return listT;

    }

    public Transaction getTransactionById(String transactionId) {
        String query = "select * from Transactions\n"
                + "where TransactionID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, transactionId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Transaction(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));

            }
        } catch (Exception e) {
        }

        return null;

    }

    public void updateStatusTransaction(String transactionId) {
        String query = "UPDATE Transactions\n"
                + "SET Status = 'Finish' \n"
                + "WHERE TransactionID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, transactionId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Transaction> getTransactionsByTypeAndStatus() {
        List<Transaction> listT = new ArrayList<>();
        String query = "select * from Transactions\n"
                + "where (TransactionType = 'Add' or TransactionType = 'Minus') and Status = 'Pending'";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listT.add(new Transaction(rs.getInt(1),
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

        return listT;

    }

    public List<Transaction> getListTransactionsByOrderId(String orderId) {
        List<Transaction> listT = new ArrayList<>();
        String query = "select * from Transactions trs\n"
                + "join Orders o on trs.OrderID = o.OrderID\n"
                + "where o.OrderID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, orderId);
            rs = ps.executeQuery();

            while (rs.next()) {
                listT.add(new Transaction(rs.getInt(1),
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

        return listT;

    }

    //p1
    public List<Product> getProductPending() {
        List<Product> listP = new ArrayList<>();
        String query = "select * from Product\n"
                + "where Status = 'Pending'";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listP.add(new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));

            }
        } catch (Exception e) {
        }

        return listP;

    }

    public void acceptProduct(String productId) {
        String query = "UPDATE Product\n"
                + "SET Status = 'Finish', Reason =''"
                + "WHERE Product.ProductID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void rejectProduct(String productId, String reason) {
        String query = "UPDATE Product\n"
                + "SET Status = 'Reject', Reason = ?\n"
                + "WHERE Product.ProductID = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, reason);
            ps.setString(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //o1
    public Orders getOrderByProductID(String productId) {
        String query = "select * from Orders o\n"
                + "join Product p on o.OrderID = p.OrderID\n"
                + "where p.ProductID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));

            }
        } catch (Exception e) {
        }

        return null;

    }

    public List<Orders> getOrderByTypeAndStatus() {
        List<Orders> listo = new ArrayList<>();
        String query = "select * from Orders\n"
                + "where OrderType != 'Paid' and Status = 'Pending'";

        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listo.add(new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }

        return listo;

    }

    public int getNumberOrderByStatus(String Status1, String Status2) {
        String query = "select count(*) from Orders\n"
                + "where Status = ? or Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Status1);
            ps.setString(2, Status2);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //w1
    public int currentBalance(int accId) {
        String query = "select Balance from \n"
                + "Wallet WHERE  AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void updateNewBalance(int accId, int newBalance) {
        String query = "UPDATE Wallet SET Balance = ? WHERE  AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, newBalance);
            ps.setInt(2, accId);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }

    }

    public void updateOrderStatus(String status, int oid) {

        String query = "UPDATE Orders\n"
                + "SET Status = ? where OrderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Set parameters
            ps.setString(1, status);
            ps.setInt(2, oid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        List<Transaction> t = dao.getListTransactions();
        List<Transaction> a = dao.getTransactionsByTypeAndStatus();
        for (Transaction transaction : a) {
            System.out.println(transaction);
        }
        List<ServicePackage> b = dao.ServicePackagesByOrderId("2");
//        Map<Account, Integer> topAccounts = dao.getTopAccountWithPurchaseCount();
//
//        for (Map.Entry<Account, Integer> entry : topAccounts.entrySet()) {
//            Account account = entry.getKey();
//            Integer purchaseCount = entry.getValue();
//
//            System.out.println("Account: " + account.getName() + " - Purchase Count: " + purchaseCount);
//        }
//        
        dao.updateStatusTransaction("12");
    }
}
