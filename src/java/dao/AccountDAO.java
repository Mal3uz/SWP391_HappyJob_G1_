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
                String img = rs.getString("img"); // Retrieve image URL from database
                Account a = new Account();
                a.setAccountID(id);
                a.setEmail(email);
                a.setName(name);
                a.setDob(dob.toString());
                a.setGender(gender);
                a.setStatus(status);
                a.setImg(img); // Set image URL
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

   public Account updateAccount(Account account) {
    // Define the SQL query to update the account information
    String query = "UPDATE Account SET";
    
    // Add email
    if (account.getEmail() != null) {
        query += " email = ?,";
    }
    
    // Add name
    if (account.getName() != null) {
        query += " name = ?,";
    }
    
    // Add dob
    if (account.getDob() != null) {
        query += " dob = ?,";
    }
    
    // Add gender
    if (account.getGender() != null) {
        query += " gender = ?,";
    }
    
    // Add img if a new image URL is provided
    if (account.getImg() != null && !account.getImg().isEmpty()) {
        query += " img = ?,";
    }
    
    // Remove the trailing comma
    query = query.substring(0, query.length() - 1);
    
    // Add WHERE clause to specify the account to update
    query += " WHERE AccountID = ?";
    
    try {
        // Get a connection to the database
        conn = new DBContext().getConnection();
        
        // Create a PreparedStatement with the query
        ps = conn.prepareStatement(query);
        
        // Set the parameters for the query
        int parameterIndex = 1;
        if (account.getEmail() != null) {
            ps.setString(parameterIndex++, account.getEmail());
        }
        if (account.getName() != null) {
            ps.setString(parameterIndex++, account.getName());
        }
        if (account.getDob() != null) {
            ps.setDate(parameterIndex++, Date.valueOf(account.getDob()));
        }
        if (account.getGender() != null) {
            ps.setString(parameterIndex++, account.getGender());
        }
        if (account.getImg() != null && !account.getImg().isEmpty()) {
            ps.setString(parameterIndex++, account.getImg());
        }
        // Set the AccountID parameter
        ps.setInt(parameterIndex++, account.getAccountID());
        
        // Execute the update query
        int affectedRows = ps.executeUpdate();
        
        // If the update was successful, return the updated account
        if (affectedRows > 0) {
            return account;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Return null if the update was not successful
    return null;
}
  
    public Account getAccountById(int accountID) {
        String sql = "SELECT * FROM account where accountID = ?;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, accountID);
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
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        Account a = ad.getAccountById(1);
        System.out.println(a);
    }


    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Account a = dao.getAccountById(1);
        a.setName("ok1");
        dao.updateAccount(a);
        System.out.println(a);
    }
}