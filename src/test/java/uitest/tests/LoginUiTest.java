package uitest.tests;

import org.junit.Test;
import uitest.support.dbsupport.dbqueries.UserDbQueries;
import uitest.support.webdriversupport.WebDriverSupport;


public class LoginUiTest extends UiTest {

    @Test
    public void openLogin() {
        System.out.println("1: " + UserDbQueries.getRandomUserName());
        System.out.println("2: " + UserDbQueries.getRandomUserName());
        System.out.println("3: " + UserDbQueries.getRandomUserName());
        System.out.println("4: " + UserDbQueries.getRandomUserName());
        System.out.println("5: " + UserDbQueries.getRandomUserName());
        System.out.println("6: " + UserDbQueries.getRandomUserName());
        System.out.println("7: " + UserDbQueries.getRandomUserName());
        System.out.println("8: " + UserDbQueries.getRandomUserName());
        System.out.println("9: " + UserDbQueries.getRandomUserName());
        System.out.println("10: " + UserDbQueries.getRandomUserName());

//        WebDriverSupport webDriverSupport = new WebDriverSupport();
//        webDriverSupport.auth();
    }
}
