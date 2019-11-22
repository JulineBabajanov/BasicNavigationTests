package day7;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CssSelectorPractice {
    public static void main(String[] args) {

        //Which locator to use
        //#1 id
        //#2 css
        //#3 xpath
        //## whatever
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        //lets find all buttons and click on them one by one
        //why I put . instead of space? because its 2 class names .btn.btn-primary
        //in this case, we will find all buttons that have: class="btn btn-primary"
        //or like this [class='btn btn-primary'], no need for .
        // . means class name
        // # means id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for(WebElement button: buttons){
            button.click();
            BrowserUtils.wait(1);
            WebElement message = driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());
        }
         driver.quit();



    }
}
