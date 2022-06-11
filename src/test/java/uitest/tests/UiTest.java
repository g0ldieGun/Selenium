package uitest.tests;

import org.junit.After;
import org.junit.Before;
import uitest.support.dbsupport.Connect;
import uitest.support.webdriversupport.AbstractWebDriverSupport;

import java.sql.Connection;
import java.sql.SQLException;

import static base.configuration.EnvPropertiesDefaults.START_PAGE;

public class UiTest extends AbstractWebDriverSupport {


    @Before
    public void setUp() {
        initializeWebDriver(START_PAGE);
    }

    @After
    public void tearDown() throws SQLException {
        closeWebDriver();
    }
}
