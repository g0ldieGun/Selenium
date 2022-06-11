package uitest.support.dbsupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static base.configuration.EnvPropertiesDefaults.DB_URL;

public class Connect {
    /**
     * main.db.Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = DB_URL;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }

        return conn;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws SQLException {
//        Connection connect = connect();
//
//        String sql = "SELECT * FROM users";
//
//        Statement statement = connect.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt("id") + "\t" +
//                    resultSet.getString("name") + "\t" +
//                    resultSet.getString("surname"));
//        }
//    }
}
