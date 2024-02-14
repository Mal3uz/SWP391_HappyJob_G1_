package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Account> getListAllAccount() {
        List<Account> listA = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listA.add(new Account(
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
                ));
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
        String query = "UPDATE Account SET Status = 'Active' WHERE AccountID = ?";
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

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        List<Account> a = dao.getListAllAccount();
        for (Account account : a) {
            System.out.println(account);
        }
    }
}
