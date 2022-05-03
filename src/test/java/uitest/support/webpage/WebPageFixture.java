package uitest.support.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPageFixture extends AbstractWebPageFixture {

    public WebPageFixture(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInButton() {
        return findElement(By.className("login"));
    }

    public WebElement getEmailInput() {
        return findElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return findElement(By.id("passwd"));
    }

    public WebElement getLoginButton() {
        return findElement(By.id("SubmitLogin"));
    }
}
