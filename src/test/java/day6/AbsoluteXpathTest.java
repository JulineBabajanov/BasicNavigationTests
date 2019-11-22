package day6;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpathTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //click on login without entering username and password
        //to invoke warning message
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //for windows control c for copy control v for paste control x cut control z step back control shift z step fwd.
        System.out.println(warningMessage.getText());//to read the text of warning message

         driver.quit(); //to end the execution




    }
}
