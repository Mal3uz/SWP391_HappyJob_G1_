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
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getNString(7),
                        rs.getNString(8),
                        rs.getInt(9)
                )
                );
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
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getNString(7),
                        rs.getNString(8),
                        rs.getInt(9)
                );
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
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getNString(7),
                        rs.getNString(8),
                        rs.getInt(9)
                )
                );
            }
            return tList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        TalentDAO td = new TalentDAO();
        ArrayList<Talent> tList = td.searchTalent("cáo");
        System.out.println(tList);
    }
}
