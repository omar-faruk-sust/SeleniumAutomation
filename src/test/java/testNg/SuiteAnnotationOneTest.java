package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteAnnotationOneTest extends BaseSuiteAnnotationTest {
    @Test(priority = 0)
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 1, enabled = false) //to skip a test
    public void checkURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
