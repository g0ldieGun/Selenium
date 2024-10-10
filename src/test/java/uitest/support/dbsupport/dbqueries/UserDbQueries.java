package uitest.support.dbsupport.dbqueries;

public class UserDbQueries {

    public static String getRandomUserName() {
        return DbQueries.executeQuery("SELECT first_name FROM\n" +
                        "( SELECT first_name FROM employees\n" +
                        "ORDER BY dbms_random.value )\n" +
                        "WHERE rownum = 1")
                .get(0);
    }
}
