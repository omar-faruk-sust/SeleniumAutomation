package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Registration {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        driver.findElement(By.id("name")).sendKeys("Omaiza Mahnoor");
        driver.findElement(By.id("email")).sendKeys("omaiza@gmail.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.id("mobile")).sendKeys("5146905454");

        driver.findElement(By.xpath("//input[@id='dob']")).click(); //Element <input id="dateOfBirthInput" class="form-control" type="text"> is not clickable at point (603,568) because another element

        //Month
        String month = "December";
//        WebElement monthsElement = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
//        Select monthsDropdown = new Select(monthsElement);
//        monthsDropdown.selectByVisibleText(month);

        //Year
        String year = "2028";
//        WebElement yearsElement = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
//        Select yearsDropDown = new Select(yearsElement);
//        yearsDropDown.selectByValue(year);

        //Day
//        String day = "18";
//        driver.findElement(By.xpath("//div[text()='18']")).click();

        // TO verify the selected date
//        String expectedDate = day +" "+ month.substring(0, 3) +" "+year;
//        System.out.println(expectedDate);
//        String actualDate = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
//        System.out.println(actualDate);
//        Assert.assertEquals(expectedDate, actualDate);

        driver.findElement(By.xpath("(//input[@id='subjects'])[1]")).sendKeys("Admission QA");

        //Thread.sleep(5000);
        //driver.findElement(By.cssSelector("label[for='Sports']")).click(); //not working
        //driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2'][type='checkbox']")).click();
        //new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='hobbies-checkbox-2']"))).click();


        driver.findElement(By.xpath("(//input[@type = 'checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();

        // File selector
        File uploadFile = new File("src/test/resources/selenium-snapshot.png");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebElement fileName = driver.findElement(By.cssSelector("[type='file'][name='picture']"));
        //Assert.assertEquals("selenium-snapshot.png", fileName.getText());

        driver.findElement(By.cssSelector("textarea[placeholder='Currend Address']")).sendKeys("3475, Rue saint Urbain, Montreal, Canada");


        WebElement state = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(state);
        stateDropdown.selectByVisibleText("NCR");

        WebElement city = driver.findElement(By.id("city"));
        Select cityDropDown = new Select(city);
        cityDropDown.selectByVisibleText("Agra");

        driver.findElement(By.cssSelector(".btn.btn-primary"));

        Thread.sleep(9000);

        driver.quit();
    }
}
