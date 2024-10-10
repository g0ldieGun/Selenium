package uitest.tests;

import org.junit.After;
import org.junit.Before;
import uitest.support.webdriversupport.AbstractWebDriverSupport;

public class UiTest extends AbstractWebDriverSupport {


    @Before
    public void setUp() {
        System.out.println("//Start");
//        initializeWebDriver(START_PAGE);
    }

    @After
    public void tearDown() {
        System.out.println("//End");
//        closeWebDriver();
    }
}
