/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author Admin
 */
public class LoginDAO {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Account login(String user, String pass){
        try {
            String query ="select * from Account where Email = ? and [Password] = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9));
                        
            }
        } catch (Exception e) {
        }
      
        return null;
    }
     public Account checkUserExist(String email){
        try {
            String query ="select * from Account where Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            
            rs = ps.executeQuery();
            while(rs.next()){
                
               return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
 
    }
    public void register(String user, String pass , String email){
        String query = "insert into Users\n"
                + "Values('?','?','?',3,1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
