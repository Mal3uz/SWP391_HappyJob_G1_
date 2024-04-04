package dao;

import entity.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BLogDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    // admin lay tat ca blog
    public ArrayList<Blog> adminGetAllBlogs() {
        try {
            String query = "select Blog.*, Account.Name from Blog inner join Account on Blog.created_by = Account.AccountID order by BlogID desc;";
            ArrayList<Blog> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blog temp = new Blog(
                        rs.getString("BlogID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("content"),
                        rs.getString("thumbnail"),
                        rs.getString("created_by"),
                        rs.getString("views"),
                        rs.getString("created_at"),
                        rs.getString("Name"),
                        rs.getString("is_verified")
                        );
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // lay 3 blog moi nhat trong db(da dc duyet)
    public ArrayList<Blog> userGet3NewestBlogs() {
        try {
            String query = "select Blog.*, Account.Name from Blog inner join Account on Blog.created_by = Account.AccountID where is_verified = 'true' order by BlogID desc;";
            ArrayList<Blog> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blog temp = new Blog(
                        rs.getString("BlogID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("content"),
                        rs.getString("thumbnail"),
                        rs.getString("created_by"),
                        rs.getString("views"),
                        rs.getString("created_at"),
                        rs.getString("Name")
                );
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // tao moi blog trong db
    public boolean createNewBlog(String admin_id, String title, String des, String content, String thumbnail){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        try {
            String query = "insert into Blog(title, description, content, thumbnail, created_by, views, created_at, is_verified) values (?, ?, ?, ?, ?, 0, ?, 'false');";
            ArrayList<Blog> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, des);
            ps.setString(3, content);
            ps.setString(4, thumbnail);
            ps.setString(5, admin_id);
            ps.setString(6, formattedTime);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // lay 1 blog voi id
    public Blog get1Blog(String id){
        try {
            String query = "select Blog.*, Account.Name from Blog inner join Account on Blog.created_by = Account.AccountID where BlogID = ? and is_verified = 'true' order by BlogID desc;" +
                            "update Blog set views = views + 1 where BlogID = ? and is_verified = 'true';";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Blog(
                        rs.getString("BlogID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("content"),
                        rs.getString("thumbnail"),
                        rs.getString("views"),
                        rs.getString("created_by"),
                        rs.getString("created_at"),
                        rs.getString("Name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // xoa blog voi id
    public boolean deleteBlog(String id){
        try {
            String query = "delete from Blog where BlogID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateBlog(String id, String title, String des, String content){ // k dung
        try {
            String query = "update Blog set title = ?, description = ?, content = ? where BlogID = ?;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, des);
            ps.setString(3, content);
            ps.setString(4, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateBlog(String id, String title, String des, String content, String thumbnail){// k dung
        try {
            String query = "update Blog set title = ?, description = ?, content = ?, thumbnail = ? where BlogID = ?;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, des);
            ps.setString(3, content);
            ps.setString(4, thumbnail);
            ps.setString(5, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // update blog co update anh
    public boolean userUpdateBlog(String id, String title, String des, String content, String thumbnail){
        try {
            String query = "update Blog set title = ?, description = ?, content = ?, thumbnail = ?, is_verified = 'false' where BlogID = ?;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, des);
            ps.setString(3, content);
            ps.setString(4, thumbnail);
            ps.setString(5, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // update blog khong update anh
    public boolean userUpdateBlog(String id, String title, String des, String content){
        try {
            String query = "update Blog set title = ?, description = ?, content = ?, is_verified = 'false' where BlogID = ?;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, des);
            ps.setString(3, content);
            ps.setString(4, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // admin duyet blog
    public boolean verifyBLog (String id){
        try {
            String query = "update Blog set is_verified = ~is_verified where BlogID = ?";
            ArrayList<Blog> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            int row_affected = ps.executeUpdate();
            return row_affected>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // lay tat ca blog cua 1 user
    public ArrayList<Blog> getUserBlog(String id){
        try {
            String query = "select Blog.*, Account.Name from Blog inner join Account on Blog.created_by = Account.AccountID where created_by = ? order by BlogID desc;";
            ArrayList<Blog> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blog temp = new Blog(
                        rs.getString("BlogID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("content"),
                        rs.getString("thumbnail"),
                        rs.getString("created_by"),
                        rs.getString("views"),
                        rs.getString("created_at"),
                        rs.getString("Name"),
                        rs.getString("is_verified")
                );
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
