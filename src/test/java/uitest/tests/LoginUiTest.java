package uitest.tests;

import org.junit.Test;
import uitest.support.webdriversupport.WebDriverSupport;


public class LoginUiTest extends UiTest{

    @Test
    public void openLogin() {
        WebDriverSupport webDriverSupport = new WebDriverSupport();
        webDriverSupport.auth();
    }
}
