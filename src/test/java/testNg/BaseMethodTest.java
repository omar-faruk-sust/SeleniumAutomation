package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.security.PublicKey;
import java.time.Duration;

public class BaseMethodTest {
    WebDriver driver;

    @BeforeMethod
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
