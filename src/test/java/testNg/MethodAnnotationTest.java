package testNg;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodAnnotationTest extends BaseMethodTest {

    @Test
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test
    public void loginFail() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("omaiza");

        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='error-message-container error']")).size(), 1);
    }

    @Test
    public void loginFailWithWrongPassword() {
        String acceptedNames =  driver.findElement(By.xpath("//div[@id='login_credentials']/h4")).getText();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("omaiza");

        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='error-message-container error']")).size(), 1);
    }
}
