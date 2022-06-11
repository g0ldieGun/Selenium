package uitest.support.webdriversupport;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import uitest.support.webpage.WebPageFixture;

import static base.configuration.EnvPropertiesDefaults.START_PAGE;

public class WebDriverSupport extends AbstractWebDriverSupport {

    public void auth() {
        initializeWebDriver(START_PAGE);

        WebPageFixture webPageFixture = new WebPageFixture(getDriver());

        webPageFixture.getSignInButton().click();
        webPageFixture.getEmailInput().sendKeys(getDefaultEmail());
        webPageFixture.getPasswordInput().sendKeys(getDefaultPassword());
        webPageFixture.getLoginButton().click();

        Assertions.assertThat(WebDriverSupport.getDriver().findElement(By.className("alert")).findElement(By.cssSelector("li")).getText()).isEqualTo("Authentication failed.");
    }
}
