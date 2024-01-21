/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Talent;
import java.security.Provider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 
    // Add new job
      public void AddTalent(String Title ,String  Description, String CreatedAt, int AccountID, String Status,String img) throws Exception {
       String   query = " INSERT INTO Talent VALUES (?,?,?,?,?,?)";
        try { conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Description);
            ps.setString(3, CreatedAt);
            ps.setInt(4, AccountID);
            ps.setString(5, Status);
            ps.setString(6, img);
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
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
                return (new Talent(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));

            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

// Delete Post
    public void deleteTalent(int pid) {
        String query = "delete from Talent where TalentID = ? ";
         

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            ps.executeUpdate();

        } catch (Exception e) {
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
   public void updateTalent(int TalentID,  String Title ,String  Description, String CreatedAt, int AccountID, String Status,String img) throws Exception {
       String   query = "update Talent set Title= ? , Description= ?, CreatedAt= ?, AccountID = ?, Status = ?, img = ?  where TalentID =?";
        try { conn = new DBContext().getConnection();
             ps = conn.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Description);
            ps.setString(3, CreatedAt);
            ps.setInt(4, AccountID);
             ps.setString(5, Status);
            ps.setString(6, img);
            ps.setInt(7 , TalentID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public static void main(String[] args) throws Exception {
        ProviderDAO p = new ProviderDAO();
      //  p.AddTalent("Edit Logo", "Make an club logo", "2024-01-13", 7, "Pending", "abc");
       // p.deleteTalent(2);
       p.updateTalent(3,"Edit Logo", "Make an club logo", "2024-01-13", 7, "Aviable", "abc");
    }
}
