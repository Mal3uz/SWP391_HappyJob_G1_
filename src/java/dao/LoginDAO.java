/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author Admin
 */
public class LoginDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private final int CODE_LENGTH = 6;

    public Account login(String user, String pass) {
        try {
            String query = "select * from Account where Email = ? and [Password] = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)
                );

            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account checkUserExist(String email) {
        try {
            String query = "select * from Account where Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)
                );
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void register(String pass, String user, String name, String dob, String gender, String verificationCode) {
        String query = "insert into Account\n"
                + "Values(?,?,?,?,?,3,'Pending',?)";
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

         public Account getVerifyCodeByEmail(String email,String verificationCode) {
        try {
            String query = "select * from Account where Email = ? and VerificationCode = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, verificationCode);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)
                );
            }
        } catch (Exception e) {
        }
        return  null;

    }
         public void verifyAccountByEmail(String email){
           try { String query = "UPDATE dbo.Account SET Status = 'Active' WHERE Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
             ps.executeUpdate();
            } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
              public void updateNewVerificationCode(String verificationCode, String email){
           try { String query = "UPDATE dbo.Account SET VerificationCode = ? WHERE Email = ?";
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
           System.out.println( dao.getAccountByEmail("phuongnampham@gmail.com"));
            
        

    }
}
