package uitest.support.dbsupport.dbqueries;

import base.configuration.EnvPropertiesDefaults;
import org.apache.commons.dbcp2.BasicDataSource;
import org.assertj.core.api.Fail;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DbQueries {

    private static BasicDataSource dataSource;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            dataSource.setUsername(System.getProperty("uitest.db.username", EnvPropertiesDefaults.db_user));
            dataSource.setPassword(System.getProperty("uitest.db.password", EnvPropertiesDefaults.db_pass));
            dataSource.setUrl(System.getProperty("uitest.db.url", EnvPropertiesDefaults.DB_URL));
            dataSource.setMaxIdle(5);
            dataSource.setInitialSize(5);
        }

        return dataSource;
    }

    static List<String> executeQuery(String query) {
        return executeQuery(query, false);
    }

    static List<String> executeQuery(String query, boolean allowEmptyList) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<String> results = jdbcTemplate.queryForList(query, String.class);

        if (!allowEmptyList && results.isEmpty()) {
            Fail.fail("No suitable test data is found");
        }

        return results;
    }

    static void executeUpdateQuery(String query) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update(query);
    }
}
