

package dao;

import entity.Account;
import entity.Messagess;
import entity.Notifications;
import entity.ServicePackage;
import entity.Talent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Account> getListAccountBySenderID(int SenderId) {
        List<Account> listA = new ArrayList<>();
        String query = "SELECT DISTINCT A.*, MAX(M.[Timestamp]) AS LatestMessageTime\n"
                + "FROM Account A\n"
                + "JOIN Messagess M ON A.AccountID = M.ReceiverID\n"
                + "WHERE M.SenderID = ?\n"
                + "GROUP BY A.AccountID, A.[Password], A.Email, A.[Name], A.Dob, A.Gender, A.RoleID, A.Status, A.Img, A.VerificationCode\n"
                + "ORDER BY LatestMessageTime DESC";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, SenderId);
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

    public int getPendingTalent() {
        String query = "select count(*) from Talent\n"
                + "where Status = 'Pending'";
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
                + "where AccountID = ?\n"
                + "order by CreatedAt desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public List<Notifications> getListNotificationsesAdmin(String accountID) {
        List<Notifications> listN = new ArrayList<>();
        String query = "select * from Notifications\n"
                + "where AccountID = ? or Message like '% created Talent%'\n"
                + "order by CreatedAt desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public List<Notifications> getNewNotificationses() {
        List<Notifications> listN = new ArrayList<>();
        String query = "SELECT TOP 3 *\n"
                + "FROM Notifications n\n"
                + "Join Talent t on n.TalentID = t.TalentID\n"
                + "ORDER BY t.CreatedAt DESC";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listN.add(new Notifications(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }

        return listN;

    }

    public int getNumberNewNotificationsesAdmin() {
        String query = "SELECT COUNT(*)\n"
                + "FROM Notifications\n"
                + "where ( Message like '% created Talent%') and Status = 0";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
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
                + "where AccountID = ? or Message like '% created Talent%'";

        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountID);
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


    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();

        List<ServicePackage> a = dao.ServicePackagesByTalentId("1");
        for (ServicePackage servicePackage : a) {
            System.out.println(servicePackage);
        }


    }

