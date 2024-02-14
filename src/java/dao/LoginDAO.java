package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

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
                        rs.getInt("accountID"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("gender"),
                        rs.getString("img"),
                        rs.getInt("roleID"),
                        rs.getString("status"),
                        rs.getString("verificationCode")
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
                        rs.getInt("accountID"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("gender"),
                        rs.getString("img"),
                        rs.getInt("roleID"),
                        rs.getString("status"),
                        rs.getString("verificationCode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
        return null;
    }

    public void register(String pass, String user, String name, String dob, String gender) {
        String query = "INSERT INTO Account (Password, Email, Name, DOB, Gender, RoleID, Status) VALUES (?, ?, ?, ?, ?, 3, 'Active')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.setString(3, name);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
        }
    }

    public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        System.out.println(dao.checkUserExist("aedfrew"));
    }
}
