package uitest.support.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractWebPageFixture {
    private final WebDriver driver;

    private static final Duration TIMEOUT_WAIT = Duration.ofSeconds(10);

    public AbstractWebPageFixture(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebElement findElement(By locator) {
        return new WebDriverWait(getDriver(), TIMEOUT_WAIT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement findElement(By locator, String containsText) {
        WebElement element = findElement(locator);
        new WebDriverWait(getDriver(), TIMEOUT_WAIT).until(arg -> element.getText().contains(containsText));
        return element;
    }

    protected List<WebElement> findElements(By locator) {
        new WebDriverWait(getDriver(), TIMEOUT_WAIT).until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        return getDriver().findElements(locator);
    }
}
