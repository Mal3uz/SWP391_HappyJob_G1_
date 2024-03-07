package dao;

import entity.Account;
import entity.Talent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.TryNode;

public class LoginDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private final int CODE_LENGTH = 6;
    
    
    //Get talent id by order id          
    public int getTalentIdByOrderId(int orderId) {
        try {
            String query = "select TalentID from Orders where OrderID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();
            while (rs.next()) {
                return  rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return 0;
    }
    
    
    // Add new rating .Bao doi raring id tu tang
    public void addRating(int talentId, int score, int accountId) throws Exception {
        Random rand = new Random(); 
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound); 
        
        String query = "INSERT INTO Rating VALUES(?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, int_random);
            ps.setInt(2, talentId);
            ps.setInt(3, score);
            ps.setInt(4, accountId);
           
            ps.executeUpdate();
            
            System.out.println("Add Success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
    }
    
    //Feedback id doi sang tu tang
    // Add new feedback
    public void addComment(String comment, int accountId, int talentId) throws Exception {
        Random rand = new Random(); 
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound); 
        String query = "INSERT INTO Feedback VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
             ps.setInt(1, int_random);
            ps.setString(2, comment);
            ps.setInt(3, accountId);
            ps.setInt(4, talentId);
           
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    

    //check talent by orderid
    public Talent getTalentByOrderId(int orderId) {
        try {
            String query = "select * from Talent where TalentID = (select TalentID from Orders where OrderID =?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();
            while (rs.next()) {

                return new Talent(
                        rs.getInt("TalentID"),
                        rs.getString("Title"),
                        rs.getString("Img"),
                        rs.getString("Description"),
                        rs.getString("CreatedAt"),
                        rs.getInt("AccountID"),
                        rs.getString("Status"),
                        rs.getString("Reason"),
                        rs.getInt("ApprovedBy")
                 
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    //check cophai seeeker
    public Account checkSeeker(int orderId) {
        try {
//            String query = "SELECT * FROM Account WHERE Email = ?";
            String query = " select * from Account where AccountID = (select AccountID from Orders where OrderID = ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(
                        rs.getInt(1),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getString("Dob"),
                        rs.getString("Gender"),
                        rs.getInt("RoleID"),
                        rs.getString("Status"),
                        rs.getString("Img"),
                        rs.getString("VerificationCode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    //Lay ra transation by orderId
    public String getTransactionStatusByOrderId(int orderId) {
        try {
//            String query = "SELECT * FROM Account WHERE Email = ?";
            String query = "select Status from Transactions where OrderID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();
            while (rs.next()) {

                return rs.getString("Status");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    public Account login(String user, String pass) {
        try {
            String query = "SELECT * FROM Account WHERE Email = ? AND [Password] = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(
                        rs.getInt(1),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getString("Dob"),
                        rs.getString("Gender"),
                        rs.getInt("RoleID"),
                        rs.getString("Status"),
                        rs.getString("Img"),
                        rs.getString("VerificationCode")
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    public Account checkUserExist(String email) {
        try {
            String query = "SELECT * FROM Account WHERE Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(
                        rs.getInt(1),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getString("Dob"),
                        rs.getString("Gender"),
                        rs.getInt("RoleID"),
                        rs.getString("Status"),
                        rs.getString("Img"),
                        rs.getString("VerificationCode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    public void register(String pass, String user, String name, String dob, String gender, String verificationCode) {
        String query = "insert into Account\n"
                + "Values(?,?,?,?,?,3,'Pending',null,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.setString(3, name);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, verificationCode);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
    }

    public String generateVerificationCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }

    public Account getVerifyCodeByEmail(String email, String verificationCode) {
        try {
            String query = "select * from Account where Email = ? and VerificationCode = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, verificationCode);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(
                        rs.getInt(1),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getString("Dob"),
                        rs.getString("Gender"),
                        rs.getInt("RoleID"),
                        rs.getString("Status"),
                        rs.getString("Img"),
                        rs.getString("VerificationCode")
                );
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void verifyAccountByEmail(String email) {
        try {
            String query = "UPDATE dbo.Account SET Status = 'Active' WHERE Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateNewVerificationCode(String verificationCode, String email) {
        try {
            String query = "UPDATE dbo.Account SET VerificationCode = ? WHERE Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, verificationCode);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccountByEmail(String email) {
        String query = "select * from Account where email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getString("Dob"),
                        rs.getString("Gender"),
                        rs.getInt("RoleID"),
                        rs.getString("Status"),
                        rs.getString("Img"),
                        rs.getString("VerificationCode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int randomNumber(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max - min) + 1) + min;
    }

    public String RandomPassword(int numberOfCharactor) {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public void updatePasswordByEmail(String pass, String email) {
        String query = "UPDATE Account SET  Password = ? WHERE email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        LoginDAO dao = new LoginDAO();
        //System.out.println(dao.checkUserExist("dat666@gmail.com"));
        System.out.println(dao.getAccountByEmail("phuongnampham@gmail.com"));

        System.out.println(dao.getTransactionStatusByOrderId(4));
        
        System.out.println(dao.getTalentByOrderId(4));
        
        dao.addRating(2, 4, 4);
        dao.addComment("fdasfsad", 4, 2);
        
    }
}
