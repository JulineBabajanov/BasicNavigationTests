package day7;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links
        //every link has a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //size of list = number of links
        //findelement vs find elements
        //findelement = only 1 webelement
        //findElemements = 0 or more elements.
        //if list is empty, that means that element is not there
       // in this way, we can ensure that element doesnt present()
        System.out.println("Number of links: "+links.size());
        //what if i want to print text of all links, one by one
        //loop through the collection of links
        for(WebElement webElement: links){
            //print text of every link
            System.out.println(webElement.getText());
        }
        driver.quit();
    }
}
