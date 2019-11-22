package day5;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestsForNameLocator {
    public static void main(String[] args) {
        //remember. for mac users:you dontn eed to use WebDriver for safari.
        //safari has webdriver support
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
         //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email
        driver.findElement(By.name("email")).sendKeys("test_email@gmail.com");
        //click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(6);
        driver.quit();
    }
}
