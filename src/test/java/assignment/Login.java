package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        //WebDriver driver = new FirefoxDriver();

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("116.0.5845.111");
        WebDriver driver = new ChromeDriver(options);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        login(driver);
        addAllItemsOnCart(driver);
    }

    private static void addAllItemsOnCart(WebDriver driver) throws InterruptedException {
        // Explicit Wait not working
        //WebDriverWait wwd = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wwd.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("app-card-list[class='row']")));
        Thread.sleep(3000);

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='card-footer']"));
        for (WebElement item : items) {
            item.findElement(By.cssSelector(".btn-info")).click();
        }

        //Both ways work
        //driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
        driver.findElement(By.partialLinkText("Checkout")).click();
    }

    private static void login(WebDriver driver) throws InterruptedException {
        String userName = "rahulshettyacademy";
        String password = "learning";

        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);

        String user = "User";
        List<WebElement> userType = driver.findElements(By.cssSelector("input[id='usertype']"));
        for (WebElement type: userType) {
            String currentUser = type.getAttribute("value");
            if(currentUser.toLowerCase().contains(user.toLowerCase())) {
                type.click();
            }
        }

        // Explicit wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button[id='okayBtn']")).click();

        String intendedOption ="Student";
        WebElement dropdownList = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(dropdownList);
        dropdown.selectByVisibleText(intendedOption);

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("signInBtn")).click();
    }
}
