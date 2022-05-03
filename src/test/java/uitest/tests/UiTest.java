package uitest.tests;

import org.junit.After;
import uitest.support.webdriversupport.AbstractWebDriverSupport;

public class UiTest extends AbstractWebDriverSupport {

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
