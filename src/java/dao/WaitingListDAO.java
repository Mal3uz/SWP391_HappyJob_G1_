/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.WaitingListItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuna
 */
public class WaitingListDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public WaitingListItem waitingListItemMapper(ResultSet rs) throws SQLException {
        int accountID = rs.getInt("accountID");
        int talentID = rs.getInt("talentID");
        int packetID = rs.getInt("packetID");

        return new WaitingListItem(accountID, talentID, packetID);
    }

    public WaitingListItem addWaitingListItem(WaitingListItem item) {
        String query = " INSERT INTO WaitingListItem(AccountID, TalentID, PacketID) VALUES (?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, item.getAccountId());
            ps.setInt(2, item.getTalentId());
            ps.setInt(3, item.getPackageId());
            ps.executeUpdate();
            return item;
        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteWaitingListItem(int accountID, int talentID) {
        String query = "DELETE FROM WaitingListItem WHERE AccountID = ? AND TalentID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, talentID);
            
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public WaitingListItem updateWaitingListItem(WaitingListItem item) {
        String query = " UPDATE WaitingListItem SET PacketID = ? WHERE AccountID = ? AND TalentID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, item.getPackageId());
            ps.setInt(2, item.getAccountId());
            ps.setInt(3, item.getTalentId());
            ps.executeUpdate();
            return item;
        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public WaitingListItem getWaitingListByAccountIDAndTalentID(int accountID, int talentID) {
        String sql = "SELECT * FROM WaitingListItem WHERE AccountID = ? AND TalentID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setInt(2, talentID);

            rs = ps.executeQuery();

            if (rs.next()) {
                return waitingListItemMapper(rs);
            }

        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean hasPendingOrFinishedOrderByAccountIDAndTalentID(int accountID, int talentID) {
        String sql = "SELECT * FROM Orders WHERE AccountID = ? AND TalentID = ? AND (Status = N'Đang thực hiện' OR Status = N'Hoàn thành');";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setInt(2, talentID);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<WaitingListItem> getWaitingListByAccountID(int accountID) {
        ArrayList<WaitingListItem> list = new ArrayList<>();
        String sql = "SELECT * FROM WaitingListItem WHERE AccountID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();

            while (rs.next()) {
                WaitingListItem item = waitingListItemMapper(rs);
                list.add(item);
            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(WaitingListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isTalentAlreadyExisted(int accountID, int talentID) {
        return (getWaitingListByAccountIDAndTalentID(accountID, talentID) != null)
                || hasPendingOrFinishedOrderByAccountIDAndTalentID(accountID, talentID);
    }

}
