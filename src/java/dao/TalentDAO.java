/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Talent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuna
 */
public class TalentDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Talent> listAllTalent() {
        ArrayList<Talent> tList = new ArrayList<>();
        String sql = "SELECT * FROM talent;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
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

    public Talent getTalentById(int talentID) {
        String sql = "SELECT * FROM talent where talentID = ?;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, talentID);
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
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Talent> searchTalent(String value) {
        ArrayList<Talent> tList = new ArrayList<>();
        String sql = "SELECT * FROM talent where title like ? ";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setNString(1, "%" + value + "%");
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

    // kiem tra xem Talent da duoc Oder hay chua
    public boolean doesTalentExist(int talentIdToCheck) throws Exception {
        // SQL query
        String sql = "SELECT COUNT(*) AS OrderCount FROM Orders WHERE TalentID = ?";

        try (
                // Establish database connection and create prepared statement
                 Connection conn = new DBContext().getConnection(); // Assuming you have a DBConnection class to get the connection
                  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            // Set parameter value
            pstmt.setInt(1, talentIdToCheck);

            // Execute query and get result set
            ResultSet rs = pstmt.executeQuery();

            // Check if any rows match the criteria
            if (rs.next()) {
                int orderCount = rs.getInt("OrderCount");
                return orderCount > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Default return value if an exception occurs
    }

    public static void main(String[] args) throws Exception {
        TalentDAO td = new TalentDAO();
//        ArrayList<Talent> tList = td.listAllTalent();
//        System.out.println(tList);
        System.out.println( td.doesTalentExist(3));
    }
}
