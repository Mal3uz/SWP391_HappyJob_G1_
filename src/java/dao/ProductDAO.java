/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ProductDAO {

    public void insertProduct(int orderId, int accountId, String urlProduct, String timestamp, String status) throws SQLException, Exception {
        String sql = "INSERT INTO Product (OrderID, AccountID, UrlProduct, [Timestamp], Status) VALUES (?, ?, ?, ?, ?)";
        try ( Connection connection = new DBContext().getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.setInt(2, accountId);
            statement.setString(3, urlProduct);
            statement.setString(4, timestamp);
            statement.setString(5, status);

            statement.executeUpdate();
        }
    }
    public static void main(String[] args) throws Exception {
        ProductDAO pdao = new ProductDAO();
        pdao.insertProduct(9, 5, "abc", "2024-01-17", "Pending");
    }
}
