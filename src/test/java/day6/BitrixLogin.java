package day6;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //we need webdriver object to send commands to the browser
        //left side is a reference veriable to reuse this object
        //object can be created and used without reference variable,
        //but its gonna be impossible to use that object moer than once.
        //enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        driver.findElement(new By.ByXPath("//*[@placeholder='Password']")).sendKeys("UserUser");
        //enter password
        //* matches any element
        //its better to specify tag name to avoid issues with finding element
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();
        BrowserUtils.wait(3);
        driver.quit();







    }
}
