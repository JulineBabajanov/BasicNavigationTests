package day11;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1() {
        //this line should be before all findElement() methods
        //to wait within 10 seconds, until element is present
        //we apply it once, and it always works
        //put this line into beforeMethod and it will work for all tests
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
        //partialLinkText we match only part of the link text
        //partial linkText we match only part of the link text
        //Example 2:Element on the page that is rendered after the trigger-link text
        //Example 2- only part of the link text
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();

        //this is for "Hello World!"
        WebElement finishElement = driver.findElement(By.id("finish"));

        System.out.println(finishElement.getText());
    }

    @Test
    public void test2() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        //select Eample # 1 through x path alternative--> //a[contains(text(), 'Example 2')]
        driver.findElement(By.partialLinkText("Example 1")).click();
        //click on start button
        driver.findElement(By.tagName("button")).click();
        //enter user name
        //explicit wait
        //we find element first
        //but, the problem is element can be present but not visible
        WebElement userNameInputBox = driver.findElement(By.id("username"));
        //we create object of WebDriverWait to apply explicity wait
        //we must provide webdriver object and period of time
        //within this period of time selenium will check every 500 milliseconds
        //if condition is true, if condition has met, no need to wait longer
        //your script will continue executing
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //how to apply condition | ExpectedConditions.condition
        //in this example, we will wait up to 10 seconds, until element is visible
        //if wait time will expire, your test will fail (due to exception)
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
         // enter user name
        userNameInputBox.sendKeys("tomsmith");
        //find webelemeent of password input box
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));

        //wait for password input box to become visible
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");
        //this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        //wait, within 10 seconds,  until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));

        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void test3() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen disappear
        //otherwise, we will have issue to click or enter the text
        wait.until(ExpectedConditions.visibilityOf(overlayScreen));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
