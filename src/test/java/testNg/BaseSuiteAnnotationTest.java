package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseSuiteAnnotationTest {
    protected WebDriver driver;

    @BeforeSuite
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
