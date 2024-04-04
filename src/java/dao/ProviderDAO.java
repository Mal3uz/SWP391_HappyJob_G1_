/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import entity.ServicePackage;
import entity.Statistic;
import entity.Talent;
import java.security.Provider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ProviderDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public ProviderDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    public ProviderDAO() {
    }

    // get talent by acc id
    public List<Talent> getTalentByAccId(int accId) {
        List<Talent> list = new ArrayList<>();
        String query = "select * from Talent where AccountID = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
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

    // Add new job
    public int AddTalent(String Title, String img, String Description, String CreatedAt, int AccountID, int cid) throws Exception {
        String query = " INSERT INTO Talent VALUES (?,?,?,?,?,'Pending',null ,null)";
        int productId = -1;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Title);
            ps.setString(2, img);
            ps.setString(3, Description);
            ps.setString(4, CreatedAt);
            ps.setInt(5, AccountID);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                productId = rs.getInt(1);
                String sql2 = "insert into [TalentCategory] values(?,?)";

                ps = conn.prepareStatement(sql2);
                ps.setInt(1, productId);
                ps.setInt(2, cid);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;
    }

//get post by ID
    public Talent getPostByID(String postid) {
        String query = "select *from Talent where TalentID  = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, postid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));

            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

// Delete 
    public void deleteTalent(int talentID) throws Exception {
        String sql = "DELETE FROM Notifications WHERE TalentID = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, talentID);
            int rowsAffected = ps.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected > 0) {
                System.out.println("Talent with ID " + talentID + " deleted successfully.");
            } else {
                System.out.println("No talent found with ID " + talentID + ".");
            }

            String sql2 = "DELETE FROM Talent WHERE TalentID = ?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, talentID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// Count total Post  
    public int getTotalPost() {
        String query = "select count (*)from Talent";
        int total = 0;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                return total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

// Edit Provider post
    public void updateTalent(int TalentID, String Title, String Description, String CreatedAt, String img, int cid) throws Exception {
        String query = "update Talent set Title= ? , Img= ?, [Description]= ?, CreatedAt = ?, Status = 'Pending'  where TalentID =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, img);
            ps.setString(3, Description);
            ps.setString(4, CreatedAt);
            ps.setInt(5, TalentID);
            ps.executeUpdate();

            String query1 = "UPDATE TalentCategory\n"
                    + "SET CategoryID = ?\n"
                    + "WHERE TalentID = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            ps.setInt(2, TalentID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Category> getAllCategory() throws Exception {
        conn = new DBContext().getConnection();
        Category category = null;
        List<Category> cList = new ArrayList<Category>();

        try {

            String sql = "select * from category order by CategoryID desc";
            PreparedStatement pstmt = this.conn.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                category = new Category();

                category.setId(resultSet.getInt("CategoryID"));
                category.setName(resultSet.getString("CategoryName"));
                cList.add(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cList;
    }

    public int addOrder(int accId, int talentId, String datetime, int packId, String status, String oderType) {

        try {
            String sql = "insert into [Orders] values(?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, talentId);
            ps.setInt(2, accId);
            ps.setString(3, datetime);
            ps.setString(4, status);
            ps.setString(5, oderType);
            ps.executeUpdate();

            String sql1 = "select top 1 orderid from [Orders] order by orderid desc";
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();

            if (rs.next()) {
                int orderId = rs.getInt(1);

                String sql2 = "insert into [orderdetail] values(?,?)";

                ps = conn.prepareStatement(sql2);
                ps.setInt(1, orderId);
                ps.setInt(2, packId);

                ps.executeUpdate();
                return orderId;
            }

        } catch (Exception e) {
        }
        return -1;
    }

    public int getIdByEmai(String email) throws Exception {
        String query = "select accountID from Account where email = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("accountID");
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

    // Count total Post  
    public int getTotalPost(int accid) {
        String query = "select count (*)from Talent Where accountid = ?";
        int total = 0;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalOrder(int accid) {
        String query = "select count (*) from Orders o\n"
                + "join Talent t on o.TalentID = t.TalentID\n"
                + "\n"
                + "Where t.AccountID = ? ";
        int total = 0;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accid);

            rs = ps.executeQuery();
            if (rs.next()) {
                return total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public List<Talent> getListAllTalentByID(int tID) {
        List<Talent> tList = new ArrayList<>();
        String sql = "SELECT * FROM talent where accountid = ?";
        try {
            conn = (Connection) new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tID);
            rs = ps.executeQuery();

            while (rs.next()) {
                tList.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
            return tList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Map<String, Object>> getOrderDetailsByDay(int accountId) throws SQLException, Exception {
        List<Map<String, Object>> orderDetailsList = new ArrayList<>();

        String query = "SELECT o.OrderID, a.Name, s.Price, s.Title, s.Description, t.Title AS TalentTitle, o.Timestamp, s.Revisions, s.Deadline, o.Status "
                + "FROM Orders o "
                + "JOIN OrderDetail od ON o.OrderID = od.OrderID "
                + "JOIN ServicePackage s ON od.PacketID = s.PacketID "
                + "JOIN Talent t ON t.TalentID = o.TalentID "
                + "JOIN Account a ON a.AccountID = o.AccountID "
                + "WHERE CAST([Timestamp] AS DATE) = CAST(GETDATE() AS DATE) "
                + "AND t.AccountID = ? "
                + "AND o.Status IN ('Pending', 'Waiting')";

        try ( Connection conn = new DBContext().getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, accountId);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> orderDetails = new HashMap<>();
                    orderDetails.put("id", rs.getString("OrderID"));
                    orderDetails.put("name", rs.getString("Name"));
                    orderDetails.put("price", rs.getDouble("Price"));
                    orderDetails.put("titles", rs.getString("Title"));
                    orderDetails.put("description", rs.getString("Description"));
                    orderDetails.put("titlet", rs.getString("TalentTitle"));
                    orderDetails.put("timestamp", rs.getTimestamp("Timestamp"));
                    orderDetails.put("revisions", rs.getInt("Revisions"));
                    orderDetails.put("deadline", rs.getInt("Deadline"));
                    orderDetails.put("status", rs.getString("Status"));
                    orderDetailsList.add(orderDetails);
                }
            }
        }

        return orderDetailsList;
    }

    public List<Map<String, Object>> getOrderDetailsByAccountId(int accountId) throws SQLException, Exception {
        List<Map<String, Object>> orderDetailsList = new ArrayList<>();

        String query = "SELECT o.OrderID, a.Name, s.Price, s.Title, s.Description,s.Type, t.Title AS TalentTitle, o.Timestamp, s.Revisions, s.Deadline, o.Status \n"
                + "                            FROM Orders o \n"
                + "                            JOIN OrderDetail od ON o.OrderID = od.OrderID \n"
                + "                            JOIN ServicePackage s ON od.PacketID = s.PacketID \n"
                + "                            JOIN Talent t ON t.TalentID = o.TalentID \n"
                + "                            JOIN Account a ON a.AccountID = o.AccountID \n"
                + "                            WHERE t.AccountID = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, accountId);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> orderDetails = new HashMap<>();
                    orderDetails.put("id", rs.getString("OrderID"));
                    orderDetails.put("name", rs.getString("Name"));
                    orderDetails.put("price", rs.getDouble("Price"));
                    orderDetails.put("serviceTitle", rs.getString("Title"));
                    orderDetails.put("description", rs.getString("Description"));
                    orderDetails.put("type", rs.getString("Type"));
                    orderDetails.put("talentTitle", rs.getString("TalentTitle"));
                    orderDetails.put("timestamp", rs.getTimestamp("Timestamp"));
                    orderDetails.put("revisions", rs.getInt("Revisions"));
                    orderDetails.put("status", rs.getString("Status"));

                    // Check if the status is "processing"
                    if ("Processing".equals(rs.getString("Status"))) {
                        // Get the current timestamp
                        Timestamp currentTimestamp = rs.getTimestamp("Timestamp");
                        // Calculate the deadline timestamp based on the current timestamp and deadline in days
                        int deadlineDays = rs.getInt("Deadline");
                        LocalDateTime deadlineDateTime = currentTimestamp.toLocalDateTime().plus(deadlineDays, ChronoUnit.DAYS);
                        Timestamp deadlineTimestamp = Timestamp.valueOf(deadlineDateTime);
                        orderDetails.put("deadline", deadlineTimestamp);
                    } else {
                        // For other statuses, use the original deadline timestamp from the database
                        orderDetails.put("deadline", rs.getInt("Deadline"));
                    }

                    orderDetailsList.add(orderDetails);
                }
            }
        }

        return orderDetailsList;
    }

    public void updateStatusByOrderId(int orderId, String status) throws SQLException, Exception {
        String query;
        if ("Processing".equals(status)) {
            // If status is "Processing", update status and set Timestamp to current time
            query = "UPDATE Orders SET Status = ?, [Timestamp] = ? WHERE OrderID = ?";
        } else {
            // If status is not "Processing", only update status
            query = "UPDATE Orders SET Status = ? WHERE OrderID = ?";
        }

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, status);
            if ("Processing".equals(status)) {
                // Set Timestamp to current time if status is "Processing"
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(3, orderId);
            } else {
                ps.setInt(2, orderId);
            }

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated == 0) {
                // Handle case when no rows are updated
                System.out.println("No order found with OrderID: " + orderId);
            } else {
                System.out.println("Status updated successfully for OrderID: " + orderId);
            }
        }
    }

    public int getAccountIdByOrderId(int orderId) throws Exception {
        String query = "SELECT AccountID FROM Orders WHERE OrderID = ?";
        int accountId = -1; // Default value if not found

        try ( Connection connection = new DBContext().getConnection();  PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    accountId = resultSet.getInt("AccountID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return accountId;
    }

    public int getWalletIdByAccountId(int accountId) throws Exception {
        String query = "SELECT WalletID FROM Wallet WHERE AccountID = ?";
        int walletId = -1; // Default value if not found

        try ( Connection connection = new DBContext().getConnection();  PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    walletId = resultSet.getInt("WalletID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return walletId;
    }

    public void insertTransaction(int wSenderId, int wReceiverId, int price, String transactionType, int orderId, String status, String transactionDate) throws Exception {
        String query = "INSERT INTO Transactions (WSenderID, WReceiverID, Price, TransactionType, OrderID, Status, TransactionDate) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try ( Connection connection = new DBContext().getConnection();  PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, wSenderId);
            statement.setInt(2, wReceiverId);
            statement.setInt(3, price);
            statement.setString(4, transactionType);
            statement.setInt(5, orderId);
            statement.setString(6, status);
            statement.setString(7, transactionDate);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    public List<Statistic> getTransLast7Day() throws Exception {
        List<Statistic> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();

            query = "SELECT p.day, COALESCE(COUNT(t.TransactionID), 0) AS count FROM (\n"
                    + "         SELECT CAST(GETDATE() AS DATE) AS day\n"
                    + "         UNION\n"
                    + "            SELECT DATEADD(DAY, -1, CAST(GETDATE() AS DATE))\n"
                    + "            UNION\n"
                    + "            SELECT DATEADD(DAY, -2, CAST(GETDATE() AS DATE))\n"
                    + "             UNION\n"
                    + "            SELECT DATEADD(DAY, -3, CAST(GETDATE() AS DATE))\n"
                    + "            UNION\n"
                    + "           SELECT DATEADD(DAY, -4, CAST(GETDATE() AS DATE))\n"
                    + "         UNION\n"
                    + "          SELECT DATEADD(DAY, -5, CAST(GETDATE() AS DATE))\n"
                    + "           UNION\n"
                    + "            SELECT DATEADD(DAY, -6, CAST(GETDATE() AS DATE))\n"
                    + "            ) AS p\n"
                    + "                    LEFT JOIN Transactions AS t ON p.day = t.TransactionDate\n"
                    + "		\n"
                    + "                    GROUP BY p.day\n"
                    + "                    ORDER BY p.day ASC;";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Statistic(rs.getDate(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            // Handle exceptions
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Handle exceptions
            }
        }

        return list;
    }

    public List<Statistic> getOrderLast7Day() throws Exception {
        List<Statistic> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();

            query = "SELECT\n"
                    + "    p.day,\n"
                    + "    COALESCE(COUNT(o.OrderID), 0) AS count\n"
                    + "FROM\n"
                    + "    (\n"
                    + "        SELECT CAST(GETDATE() AS DATE) AS day\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -1, CAST(GETDATE() AS DATE))\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -2, CAST(GETDATE() AS DATE))\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -3, CAST(GETDATE() AS DATE))\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -4, CAST(GETDATE() AS DATE))\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -5, CAST(GETDATE() AS DATE))\n"
                    + "        UNION\n"
                    + "        SELECT DATEADD(DAY, -6, CAST(GETDATE() AS DATE))\n"
                    + "    ) AS p\n"
                    + "LEFT JOIN Orders AS o ON CAST(o.[Timestamp] AS DATE) = p.day\n"
                    + "GROUP BY\n"
                    + "    p.day\n"
                    + "ORDER BY\n"
                    + "    p.day ASC;";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Statistic(rs.getDate(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            // Handle exceptions
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Handle exceptions
            }
        }

        return list;
    }

    public int incomeStatic() throws SQLException, Exception {
        int income = 0;
        String query = "SELECT "
                + "    SUM(t.Price) AS TotalPrice "
                + "FROM "
                + "    Transactions t "
                + "JOIN "
                + "    Orders o ON t.OrderID = o.OrderID "
                + "WHERE "
                + "    MONTH(t.TransactionDate) = MONTH(GETDATE()) "
                + "    AND YEAR(t.TransactionDate) = YEAR(GETDATE()) "
                + "    AND o.Status = 'Finish' "
                + "    AND t.TransactionType = 'Paid'";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                income = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return income;
    }

    public int incomeStaticLastMonth() throws SQLException, Exception {
        int income = 0;

        // Get the first day of the last month
        LocalDate firstDayOfLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);

        String query = "SELECT "
                + "    SUM(t.Price) AS TotalPrice "
                + "FROM "
                + "    Transactions t "
                + "JOIN "
                + "    Orders o ON t.OrderID = o.OrderID "
                + "WHERE "
                + "    MONTH(t.TransactionDate) = MONTH(?) "
                + "    AND YEAR(t.TransactionDate) = YEAR(?) "
                + "    AND o.Status = 'Finish' "
                + "    AND t.TransactionType = 'Paid'";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            // Set parameters
            ps.setObject(1, firstDayOfLastMonth);
            ps.setObject(2, firstDayOfLastMonth);

            rs = ps.executeQuery();

            if (rs.next()) {
                income = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return income;
    }

    public int incomeStaticById(int pId) throws SQLException, Exception {
        int income = 0;
        String query = "	SELECT \n"
                + "    SUM(t.Price) AS TotalPrice \n"
                + "FROM \n"
                + "    Transactions t\n"
                + "JOIN \n"
                + "    Orders o ON t.OrderID = o.OrderID\n"
                + "	join\n"
                + "	Talent tl on o.TalentID = tl.TalentID\n"
                + "WHERE \n"
                + "    \n"
                + "	 o.Status = 'Finish'\n"
                + "	and t.TransactionType = 'Paid'\n"
                + "	and tl.AccountID = ?\n"
                + "    ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pId);
            rs = ps.executeQuery();

            if (rs.next()) {
                income = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return income;
    }

    //code here
    public void addOrderDetail(int orderId, int packetid[]) throws Exception {
        String sql = "insert into [orderdetail] values(?,?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            for (int packId : packetid) {
                ps.setInt(1, orderId);
                ps.setInt(2, packId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần thiết
            e.printStackTrace();

        }

    }

    public List<ServicePackage> getListServicePackageTalentByID(int tID) {
        List<ServicePackage> tList = new ArrayList<>();
        String sql = "SELECT * FROM ServicePackage \n"
                + "where TalentID = ? ";
        try {
            conn = (Connection) new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tID);
            rs = ps.executeQuery();

            while (rs.next()) {
                tList.add(new ServicePackage(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
            return tList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int totalPriceOrder(int orderid) throws SQLException, Exception {
        int total = 0;
        String query = " select sum(Price) from ServicePackage sp\n"
                + " join OrderDetail od on sp.PacketID = od.PacketID\n"
                + " join  Orders o on o.OrderID = od.OrderID\n"
                + " where o.OrderID = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderid);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1); // get the sum from the result set
            }
        } catch (SQLException e) {
            // handle exception
        } finally {
            // close resources
        }

        return total;
    }

    public void addServicePacket(int orderId, int packetid[]) throws Exception {
        String sql = "insert into [orderdetail] values(?,?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            for (int packId : packetid) {
                ps.setInt(1, orderId);
                ps.setInt(2, packId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần thiết
            e.printStackTrace();

        }
    }

    public void addServicePacket(int talentId, String title, String description, int price, int revisions, int deadline) throws Exception {
        String query = "INSERT INTO ServicePackage(TalentID, Title, Description, Price, Revisions, Type,Deadline)\n"
                + "VALUES(?,?,?,?,?,'Add',?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, talentId);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setInt(4, price);
            ps.setInt(5, revisions);
            ps.setInt(6, deadline);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    public ServicePackage getServicePackageById(String spid) {
        String query = "select * from ServicePackage \n"
                + "where PacketID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, spid);
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

    public void updateServicePackage(int packageid, String title, String description, int price, int revisions, int deadline) {
        String query = "UPDATE ServicePackage\n"
                + "SET title = ?,Description = ?, Price = ?, Revisions= ?, Deadline = ?\n"
                + "Where PacketID = ?";

        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            // Set parameters
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, price);
            ps.setInt(4, revisions);
            ps.setInt(5, deadline);
            ps.setInt(6, packageid);
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void deleteServicePackage(String id) {
        String query = " Delete from ServicePackage\n"
                + "Where PacketID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id); // Truyền tham số vào câu truy vấn
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        ProviderDAO p = new ProviderDAO();
        //  p.AddTalent("Edit Logo", "abc", "Make an club logo", "2024-01-13", 7, 6);
        // p.deleteTalent(2);
        //   p.updateTalent(3, "Edit Logo", "Make an club logo", "2024-01-13", 7, "Aviable", "abc");
//        List<Talent> list = new ArrayList<>();
//        list = p.getTalentByAccId(13);
//        for (Talent talent : list) {
//            System.out.println(talent);
//        }
        //  p.addOrder(4, 2, "2024-01-01",2, 2000,"Pending");
        //  int id = p.getIdByEmai("datdvhe172079@fpt.edu.vn");
        // System.out.println(id);
//       List<Talent> list = new ArrayList<>();
//       list = p.getListAllTalentByID(5);
//        for (Talent talent : list) {
//            System.out.println(talent);
//        }
        // p.deleteTalent(13);
//        List<Map<String, Object>> orderDetailsList = p.getOrderDetailsByAccountId(5);
//
//        for (Map<String, Object> orderDetails : orderDetailsList) {
//            System.out.println("ID: " + orderDetails.get("id"));
//            System.out.println("Account Name: " + orderDetails.get("name"));
//            System.out.println("Price: " + orderDetails.get("price"));
//            System.out.println("Service Title: " + orderDetails.get("titles"));
//            System.out.println("Description: " + orderDetails.get("description"));
//            System.out.println("Talent Title: " + orderDetails.get("titlet"));
//            System.out.println("Timestamp: " + orderDetails.get("timestamp"));
//            System.out.println("Revisions: " + orderDetails.get("revisions"));
//            System.out.println("Deadline: " + orderDetails.get("deadline"));
//            System.out.println("Status: " + orderDetails.get("status"));
//            System.out.println();
//        }
        int i = p.incomeStaticById(5);
        System.out.println(i);

    }
}
