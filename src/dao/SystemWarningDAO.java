package dao;

import model.SystemWarning;
import java.sql.*;
import java.util.*;

public class SystemWarningDAO {
    
    public boolean addWarning(String systemName, String message, String severity) throws Exception {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO system_warnings (system_name, warning_message, severity_level) VALUES (?, ?, ?)"
            );
            ps.setString(1, systemName);
            ps.setString(2, message);
            ps.setString(3, severity);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    public int countWarnings() {
        int count = 0;
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM system_warnings");
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<SystemWarning> getAllWarnings() {
        List<SystemWarning> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM system_warnings ORDER BY created_at DESC");

            while (rs.next()) {
                list.add(new SystemWarning(
                    rs.getInt("id"),
                    rs.getString("system_name"),
                    rs.getString("warning_message"),
                    rs.getString("severity_level")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SystemWarning> getFilteredWarnings() {
        List<SystemWarning> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM system_warnings WHERE severity_level = 'Critical' ORDER BY created_at DESC"
            );

            while (rs.next()) {
                list.add(new SystemWarning(
                    rs.getInt("id"),
                    rs.getString("system_name"),
                    rs.getString("warning_message"),
                    rs.getString("severity_level")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
