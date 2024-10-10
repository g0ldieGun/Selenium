package uitest.support.webdriversupport;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import static base.configuration.EnvPropertiesDefaults.*;

public class AbstractWebDriverSupport {
    private static WebDriver driver;

    private static final String EMAIL = WEB_EMAIL;
    private static final String PASSWORD = WEB_PASSWORD;

    private static final Duration TIMEOUT_WAIT = Duration.ofSeconds(10);

    protected void initializeWebDriver(String link) {
        String chromeDriverFile = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", Paths.get(".").toAbsolutePath() + "\\target\\test-classes\\webdriver\\" + chromeDriverFile);

        if (driver == null) {
            System.out.println("New Driver instance created");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get(link);
            driver.manage().window().maximize();
        }
    }

    protected void completePageLoading() {
        new WebDriverWait(driver, TIMEOUT_WAIT).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        System.out.println("Page loading complete");
    }

    protected void closeWebDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }

        String[] command = {"cmd.exe", "/C", "Start", Paths.get(".").toAbsolutePath() + "\\target\\test-classes\\webdriver\\" + "killChrome.bat"};
        try {
            Process p =  Runtime.getRuntime().exec(command);
            p.destroy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getDefaultEmail(){
        return EMAIL;
    }

    public static String getDefaultPassword(){
        return PASSWORD;
    }
}
