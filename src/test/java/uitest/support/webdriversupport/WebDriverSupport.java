package uitest.support.webdriversupport;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import uitest.support.webpage.WebPageFixture;

public class WebDriverSupport extends AbstractWebDriverSupport {

    private static final String automationLink = "http://automationpractice.com/index.php";

    public void auth() {
        initializeWebDriver(automationLink);

        WebPageFixture webPageFixture = new WebPageFixture(getDriver());

        webPageFixture.getSignInButton().click();
        webPageFixture.getEmailInput().sendKeys(getDefaultEmail());
        webPageFixture.getPasswordInput().sendKeys(getDefaultPassword());
        webPageFixture.getLoginButton().click();

        Assertions.assertThat(WebDriverSupport.getDriver().findElement(By.className("alert")).findElement(By.cssSelector("li")).getText()).isEqualTo("Authentication failed.");
    }
}
