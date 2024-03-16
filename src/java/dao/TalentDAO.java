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
import java.util.List;

/**
 *
 * @author tuna
 */
public class TalentDAO {

     Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Talent> listAllTalent() {
        List<Talent> tList = new ArrayList<>();
        String sql = "SELECT * FROM talent;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tList.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
            return tList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Talent> pagingActiveTalent(int index) {
        List<Talent> list = new ArrayList<>();
        String sql = "select * from Talent\n"
                + "where Status = 'Active'\n"
                + "order by TalentID\n"
                + "OFFSET ? rows fetch next 4 rows only;";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Talent> getTalentByOrderStatus(int accountId, String status) {
        List<Talent> list = new ArrayList<>();
        String sql = "select * from Talent t\n"
                + "join Orders o on t.TalentID = o.TalentID\n"
                + "where o.AccountID = ? and o.Status = ? ";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.setString(2, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getNumberTalentByActive() {
        String sql = "select count(*) from Talent\n"
                + "where Status = 'Active'";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getNumberOrderOfTalent(int talentId) {
        String sql = "SELECT COUNT(o.OrderID) AS TotalCompletedOrders\n"
                + "FROM Talent t\n"
                + "JOIN Orders o ON t.TalentID = o.TalentID\n"
                + "WHERE t.TalentID = ? AND o.Status = 'Completed';";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, talentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double getNumberRatingOfTalent(int talentId) {
        String sql = "SELECT ROUND(SUM(CAST(r.Score AS FLOAT)) / COUNT(r.Score), 2) AS AverageRating\n"
                + "FROM Talent t JOIN Rating r ON t.TalentID = r.TalentID\n"
                + "WHERE t.TalentID = ?";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, talentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Talent> getTalentByCriteria(String txt, int star, int minPrice, int maxPrice, int index) {
        List<Talent> filterTalents = new ArrayList<>();

        StringBuilder query = new StringBuilder("SELECT DISTINCT T.TalentID, T.Title, T.Img, T.[Description], T.CreatedAt, T.AccountID, T.[Status], T.[Reason], T.[ApprovedBy]\n"
                + "FROM Talent T\n"
                + "LEFT JOIN Rating R ON T.TalentID = R.TalentID\n"
                + "LEFT JOIN ServicePackage SP ON T.TalentID = SP.TalentID AND SP.Type = 'basic'\n"
                + "WHERE T.Status = 'Active'");

        if (txt != null) {
            query.append(" AND T.Title LIKE ?");
        }

        if (maxPrice >= 1000) {
            query.append(" AND SP.Price BETWEEN ? AND ?");
        }

        if (star >= 3) {
            query.append(" GROUP BY T.TalentID, T.Title, T.Img, T.[Description], T.CreatedAt, T.AccountID, T.[Status], T.[Reason], T.[ApprovedBy]\n"
                    + "HAVING ROUND(SUM(CAST(R.Score AS FLOAT)) / COUNT(R.Score), 2) >= ?");
        }

        query.append(" ORDER BY T.TalentID OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY;");

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(query.toString());
            int parameterIndex = 1; // Start parameter index

            if (txt != null) {
                ps.setString(parameterIndex++, "%" + txt + "%");
            }

            if (maxPrice >= 1000) {
                ps.setInt(parameterIndex++, minPrice);
                ps.setInt(parameterIndex++, maxPrice);
            }

            if (star >= 3) {
                ps.setInt(parameterIndex++, star);
            }

            ps.setInt(parameterIndex++, (index - 1) * 4);
            rs = ps.executeQuery();

            while (rs.next()) {
                filterTalents.add(new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            // Handle exceptions
            System.out.println(e);
        }

        return filterTalents;
    }

    public int getTotalTalentCountByCriteria(String txt, int star, int minPrice, int maxPrice) {
        int totalCount = 0;
        StringBuilder query = new StringBuilder(" SELECT COUNT(*) AS total_count FROM ( SELECT DISTINCT T.TalentID, T.Title, T.Img, T.[Description], T.CreatedAt, T.AccountID, T.[Status], T.[Reason], T.[ApprovedBy]\n"
                + "FROM Talent T\n"
                + "LEFT JOIN Rating R ON T.TalentID = R.TalentID\n"
                + "LEFT JOIN ServicePackage SP ON T.TalentID = SP.TalentID AND SP.Type = 'basic'\n"
                + "WHERE T.Status = 'Active'");

        if (txt != null) {
            query.append(" AND T.Title LIKE ?");
        }

        if (maxPrice >= 1000) {
            query.append(" AND SP.Price BETWEEN ? AND ?");
        }

        if (star >= 3) {
            query.append(" GROUP BY T.TalentID, T.Title, T.Img, T.[Description], T.CreatedAt, T.AccountID, T.[Status], T.[Reason], T.[ApprovedBy]\n"
                    + "HAVING ROUND(SUM(CAST(R.Score AS FLOAT)) / COUNT(R.Score), 2) >= ?");
        }

        query.append(") AS subquery;");

        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(query.toString());
            int parameterIndex = 1; // Start parameter index

            if (txt != null) {
                ps.setString(parameterIndex++, "%" + txt + "%");
            }

            if (maxPrice >= 1000) {
                ps.setInt(parameterIndex++, minPrice);
                ps.setInt(parameterIndex++, maxPrice);
            }

            if (star >= 3) {
                ps.setInt(parameterIndex++, star);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt("total_count");
            }
        } catch (Exception e) {
            // Handle exceptions
            System.out.println(e);
        }
        System.out.println(query);
        return totalCount;
    }

    public Talent getTalentById(String talentId) {
        String query = "select * from Talent \n"
                + "where TalentID = ?";
        try {
            con = (Connection) new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, talentId);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Talent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
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
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
            return tList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        TalentDAO td = new TalentDAO();
        double count = td.getNumberRatingOfTalent(6);
        System.out.println(count);

        List<Talent> t = td.getTalentByCriteria("d", 3, 0, 0, 2);
        int number = td.getTotalTalentCountByCriteria("d", 3, 0, 0);
        System.out.println(number);
        for (Talent talent : t) {
            System.out.println(talent);
        }
    }
}
