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
import java.util.ArrayList;

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
    
    public ServicePackage getServicePackageByID(int id) {
        String sql = "SELECT * FROM ServicePackage WHERE packetID = ?";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new ServicePackage(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getNString(7).toLowerCase(),
                        rs.getInt(8)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ServicePackageDAO sd = new ServicePackageDAO();
        ArrayList<ServicePackage> lPackage = sd.listPackage(4);
        System.out.println(lPackage);
    }
}
