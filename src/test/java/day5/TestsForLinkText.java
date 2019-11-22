package day5;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestsForLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("http://practice.cybertekschool.com/");
        //Autocomplete-its the text that you see in the link
        //place where will navigate you specified in href
        //it only works if tag name is <a>


        driver.findElement(By.linkText("Autocomplete")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
