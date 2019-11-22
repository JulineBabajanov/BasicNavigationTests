package day5;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestsForIdLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//id="disappearing_button"
        WebElement button =driver.findElement(By.id("disappearing_button"));

        button.click();
        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());

        driver.quit();

    }
}
