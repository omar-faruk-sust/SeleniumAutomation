package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClassAnnotationTest {
    WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
