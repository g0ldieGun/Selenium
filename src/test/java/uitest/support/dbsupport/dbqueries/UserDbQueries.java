package uitest.support.dbsupport.dbqueries;

public class UserDbQueries {


    public static String getRandomUserName() {
        String sql = "SELECT name FROM users ORDER BY RANDOM() LIMIT 1;";

        return DbQueries.executeQuery(sql);
    }
}
