package testNg;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassAnnotationTest extends BaseClassAnnotationTest {

    @Test(priority = 0)
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 1, enabled = false) //to skip a test
    public void checkURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 2)
    public void loginFail() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("omaiza");

        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='error-message-container error']")).size(), 1);
    }

    @Test(priority = 3)
    public void loginFailWithWrongPassword() {
        String acceptedNames =  driver.findElement(By.xpath("//div[@id='login_credentials']/h4")).getText();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("omaiza");

        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='error-message-container error']")).size(), 1);
    }

    @Test(priority = 4)
    public void loginPass() {
        driver.navigate().refresh();
        String acceptedNames =  driver.findElement(By.xpath("//div[@id='login_credentials']/h4")).getText();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("#login-button")).click();

        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        String logoutText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutText, "Logout");
    }
}
