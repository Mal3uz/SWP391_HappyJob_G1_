/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Orders getOrderByTAID(int accountId , String talentId) {
        String query = "select * from Orders o\n"
                + "join Talent t on o.TalentID = t.TalentID\n"
                + "where t.TalentID = ? and o.AccountID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
             ps.setString(1, talentId);
             ps.setInt(2, accountId);
           
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));

            }
        } catch (Exception e) {
        }

        return null;

    }

}
