/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import entity.Talent;
import java.security.Provider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public void AddTalent(String Title, String img, String Description, String CreatedAt, int AccountID) throws Exception {
        String query = " INSERT INTO Talent VALUES (?,?,?,?,?,'Pending',null ,null)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, img);
            ps.setString(3, Description);
            ps.setString(4, CreatedAt);
            ps.setInt(5, AccountID);

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
    public void updateTalent(int TalentID, String Title, String Description, String CreatedAt, int AccountID, String Status, String img) throws Exception {
        String query = "update Talent set Title= ? , Description= ?, CreatedAt= ?, AccountID = ?, Status = ?, img = ?  where TalentID =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Description);
            ps.setString(3, CreatedAt);
            ps.setInt(4, AccountID);
            ps.setString(5, Status);
            ps.setString(6, img);
            ps.setInt(7, TalentID);
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

    public void addOrder(int accId, int talentId, String datetime, int packId) {

        try {
            String sql = "insert into [Orders] values(?,?,?,'Waiting')";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, talentId);
            ps.setInt(2, accId);
            ps.setString(3, datetime);
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
            }

        } catch (Exception e) {
        }
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

    public static void main(String[] args) throws Exception {
        ProviderDAO p = new ProviderDAO();
        //p.AddTalent("Edit Logo","abc", "Make an club logo", "2024-01-13", 7);
        // p.deleteTalent(2);
        //   p.updateTalent(3, "Edit Logo", "Make an club logo", "2024-01-13", 7, "Aviable", "abc");
//        List<Talent> list = new ArrayList<>();
//        list = p.getTalentByAccId(13);
//        for (Talent talent : list) {
//            System.out.println(talent);
//        }
      //  p.addOrder(4, 2, "2024-01-01", 2);
     int id = p.getIdByEmai("datdvhe172079@fpt.edu.vn");
        System.out.println(id);
    }
}
