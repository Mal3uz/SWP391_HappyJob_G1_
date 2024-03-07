package dao;

import entity.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingDAO {
    private Connection connection;

    public RatingDAO() {
        try {
            // Initialize the connection to the database
            this.connection = new DBContext().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Rating> getRatingsByTalentID(int talentID) {
        List<Rating> ratings = new ArrayList<>();
        String query = "SELECT r.*, a.AccountName " +
                       "FROM Rating r " +
                       "JOIN Account a ON r.AccountID = a.AccountID " +
                       "WHERE r.TalentID = ?";

        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, talentID);
            rs = statement.executeQuery();

            while (rs.next()) {
                Rating rating = new Rating();
                rating.setRatingID(rs.getInt("RatingID"));
                rating.setTalentID(rs.getInt("TalentID"));
                rating.setScore(rs.getInt("Score"));
                rating.setAccountID(rs.getInt("AccountID"));
                rating.setAccountName(rs.getString("AccountName"));
                ratings.add(rating);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ratings;
    }
}
