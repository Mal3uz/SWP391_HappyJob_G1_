/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ServicePackage;
import entity.Talent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuna
 */
public class ServicePackageDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<ServicePackage> listPackage(int talentID) {
        ArrayList<ServicePackage> sList = new ArrayList<>();
        String sql = "SELECT * FROM servicepackage where talentID= ?";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, talentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                sList.add(new ServicePackage(rs.getInt(1),
                        rs.getInt(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getNString(7).toLowerCase(),
                        rs.getInt(8)
                )
                );
            }
            return sList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ServicePackage> getServicePackageByID(int spid) {
        String query = "SELECT * FROM servicepackage WHERE packetID = ?";
        List<ServicePackage> list = new ArrayList<>();

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, spid);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ServicePackage servicePackage = new ServicePackage(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getInt(8)
                    );
                    list.add(servicePackage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // or log the exception
        } catch (Exception ex) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTalentIDByPackId(int packId) throws Exception {
        String query = "SELECT TalentID FROM [ServicePackage] WHERE PacketID = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, packId);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                return rs.getInt("TalentID");
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
    
    public int getPriceByPackId(int packId) throws Exception {
        String query = "SELECT Price FROM [ServicePackage] WHERE PacketID = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, packId);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                return rs.getInt("Price");
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

    public static void main(String[] args) {
        try {
            ServicePackageDAO sd = new ServicePackageDAO();
            List<ServicePackage> lPackage = sd.getServicePackageByID(5);
//        System.out.println(lPackage);
         int a =  sd.getPriceByPackId(2);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

}
