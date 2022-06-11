package uitest.support.dbsupport.dbqueries;

import uitest.support.dbsupport.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQueries {

    public static String executeQuery(String sql) {
        String randomName = "";

        Connection connect = Connect.connect();

        try (Connection conn = connect;
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            randomName = rs.getString("name");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return randomName;
    }
}
