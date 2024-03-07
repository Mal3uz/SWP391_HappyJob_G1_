package dao;

import entity.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Feedback> getFeedbacksByTalentID(int talentID) {
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT f.*, a.AccountName " +
                           "FROM Feedback f " +
                           "JOIN Account a ON f.AccountID = a.AccountID " +
                           "WHERE f.TalentID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, talentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackID(rs.getInt("FeedbackID"));
                feedback.setContent(rs.getString("Content"));
                feedback.setAccountID(rs.getInt("AccountID"));
                feedback.setTalentID(rs.getInt("TalentID"));
                feedback.setAccountName(rs.getString("AccountName"));
                feedbackList.add(feedback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return feedbackList;
    }
}
