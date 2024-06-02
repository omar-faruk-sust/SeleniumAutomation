package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class RegistrationOfDemoQa {
    public static void main(String[] args) throws InterruptedException {
            //WebDriver driver = new FirefoxDriver();

            //
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("116.0.5845.111");
            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.manage().window().maximize();

            //driver.get("https://demoqa.com/");
            //driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1]")).click();

            driver.get("https://demoqa.com/automation-practice-form");

            driver.findElement(By.id("firstName")).sendKeys("Omaiza Mahnoor");
            driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Faruk");
            driver.findElement(By.id("userEmail")).sendKeys("omaiza@gmail.com");

            Thread.sleep(2000);
            driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
            //driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();

           //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
           //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='gender-radio-2']"))).click();

           //wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-radio-2"))).click();
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='gender-radio-2']"))).click();

    //        String intendedGender = "Female";
    //        driver.findElements(By.cssSelector("input[type='radio']")).stream()
    //                .filter(webElement -> webElement.getAttribute("value").equalsIgnoreCase(intendedGender))
    //                        .findFirst().get().click();

    //        for (int i = 0; genderRadioButtons.size() > i; i++) {
    //            String SelectedGender = genderRadioButtons.get(i).getAttribute("value");
    //            if(SelectedGender.equalsIgnoreCase(intendedGender)) {
    //
    //                //genderRadioButtons.get(i).click();
    //                //driver.findElement(By.cssSelector("input[type='radio'] [value='"+ SelectedGender +"']")).isSelected();
    //                driver.findElement(By.cssSelector("input[id='"+ genderRadioButtons.get(i).getAttribute("id") +"']")).click();
    //                //driver.findElement(By.cssSelector("+ genderRadioButtons.get(i).getAttribute("id") +")).click();
    //                break;
    //            }
    //        }

            driver.findElement(By.id("userNumber")).sendKeys("5146905454");

            Thread.sleep(5000);

            driver.findElement(By.id("dateOfBirthInput")).click(); //Element <input id="dateOfBirthInput" class="form-control" type="text"> is not clickable at point (603,568) because another element

            //Month
            String month = "December";
            WebElement monthsElement = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
            Select monthsDropdown = new Select(monthsElement);
            monthsDropdown.selectByVisibleText(month);

            //Year
            String year = "2028";
            WebElement yearsElement = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
            Select yearsDropDown = new Select(yearsElement);
            yearsDropDown.selectByValue(year);

            //Day
            String day = "18";
            driver.findElement(By.xpath("//div[text()='18']")).click();

            // TO verify the selected date
            String expectedDate = day +" "+ month.substring(0, 3) +" "+year;
            System.out.println(expectedDate);
            String actualDate = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
            System.out.println(actualDate);
            Assert.assertEquals(expectedDate, actualDate);

            driver.findElement(By.id("subjectsInput")).sendKeys("Admission QA");

            //Thread.sleep(5000);
            //driver.findElement(By.cssSelector("label[for='Sports']")).click(); //not working
            //driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2'][type='checkbox']")).click();
            //new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='hobbies-checkbox-2']"))).click();


            /*ArrayList<String> hobbies = new ArrayList<>();
            hobbies.add("Sports");
            hobbies.add("Music");

            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type = 'checkbox']"));
            for (WebElement checkbox:checkboxes) {
                System.out.println(checkbox.getAttribute("value"));
                String checkboxId = checkbox.getAttribute("id");
                String label = driver.findElement(By.cssSelector("label[for='"+checkboxId+"']")).getText();
                if(hobbies.contains(label) && !checkbox.isSelected()) {
                    // checkbox.click();
                    // driver.findElement(By.id(checkboxId)).click();
                    // driver.findElement(By.cssSelector("label[for='"+id+"']")).click();

                    new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='"+checkboxId+"']"))).click();
                }
            }*/

            driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

            // File selector
            File uploadFile = new File("src/test/resources/selenium-snapshot.png");

            WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
            fileInput.sendKeys(uploadFile.getAbsolutePath());

            WebElement fileName = driver.findElement(By.id("uploadPicture"));
            //Assert.assertEquals("selenium-snapshot.png", fileName.getText());

            //Thread.sleep(2000);
            driver.findElement(By.cssSelector("textarea[id='currentAddress']")).sendKeys("3475, Rue saint Urbain, Montreal, Canada");
            //Thread.sleep(2000);
            //div[id*='react-select-3-option-']
            //NCR //#react-select-3-input
            //<div class=" css-9gakcf-option" id="react-select-3-option-0" tabindex="-1" xpath="1">NCR</div>
            /*List<WebElement> select3 =  driver.findElements(By.cssSelector("div[id*='react-select-3-option-']"));

            for (int j = 0; j < select3.size(); j++) {
                System.out.println(select3.get(j).getText());
            }*/

            //react-select-3-input
            WebElement state = driver.findElement(By.id("react-select-3-option-2"));
            if (state.isDisplayed()) {
                state.click();
            }

            //Thread.sleep(2000);

            WebElement city = driver.findElement(By.id("react-select-4-option-1"));
            if (city.isDisplayed()) {
                city.click();
            }

            driver.findElement(By.cssSelector("button[id='submit']"));


            driver.quit();
    }
}
