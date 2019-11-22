package day12;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassHoverPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
         driver = BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/hovers");
    }
    @Test(description = "Verify first image")
    public void test1(){
        Actions action = new Actions(driver);
        WebElement image1=driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        //just to hover on element not click it
        //build() is required when we have more than 1 action in a chain
        //without .perform(); it will not work
        //moveToElement = hover
        //.perform() stands for triggering actions
        action.moveToElement(image1).perform();

        BrowserUtils.wait(3);
        //h5 is a grand child of .figure:nth-of-type(1) this element that contains image
        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));

        String expectedText = "name: user1";
        String actualText = textOfImageElement.getText();

        Assert.assertEquals(actualText, expectedText);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
