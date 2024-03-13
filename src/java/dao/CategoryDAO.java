/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CategoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //a1
    public List<Category> getListAllCategories() {
        List<Category> listA = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new DBContext().getConnection();//mo ket noi vs sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                listA.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }

        return listA;

    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<Category> a = dao.getListAllCategories();
        for (Category account : a) {
            System.out.println(account);
        }
        System.out.println("ok");
    }
}
