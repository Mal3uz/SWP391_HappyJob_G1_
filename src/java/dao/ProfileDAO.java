package dao;

import entity.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileDAO {
    private Connection connection;
    


    public ProfileDAO(DBContext dbContext) {
        try {
            this.connection = dbContext.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profile getProfileData(int accountID) throws SQLException {
        Profile profile = null;
        String query = "SELECT * FROM userProfile WHERE AccountID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    profile = new Profile();
                    profile.setAccountID(resultSet.getInt("AccountID"));
                    profile.setName(resultSet.getString("name"));
                    profile.setEmail(resultSet.getString("email"));
                    profile.setPassword(resultSet.getString("password"));
                    profile.setGender(resultSet.getString("gender"));
                    profile.setAbout(resultSet.getString("about"));
                    profile.setBirthday(resultSet.getString("birthday"));
                }
            }
        }
        return profile;
    }

    public Profile authenticateUser(String email, String password) throws SQLException {
        Profile profile = null;
        String query = "SELECT * FROM userProfile WHERE Email = ? AND Password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    profile = new Profile();
                    profile.setAccountID(resultSet.getInt("AccountID"));
                    profile.setName(resultSet.getString("name"));
                    profile.setEmail(resultSet.getString("email"));
                    profile.setPassword(resultSet.getString("password"));
                    profile.setGender(resultSet.getString("gender"));
                    profile.setAbout(resultSet.getString("about"));
                    profile.setBirthday(resultSet.getString("birthday"));
                }
            }
        }
        return profile;
    }

    public void updateProfile(int accountID, String name, String email, String gender, String about, String birthday)
            throws SQLException {
        String query = "UPDATE userProfile SET name=?, email=?, gender=?, about=?, birthday=? WHERE AccountID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, about);
            preparedStatement.setString(5, birthday);
            preparedStatement.setInt(6, accountID);

            preparedStatement.executeUpdate();
        }
    }
}