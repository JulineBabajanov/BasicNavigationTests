package day12;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    @Test(description = "Drag and drop example")
    public void test1(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        //accept cookies
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
        Actions actions = new Actions(driver);

        //moon- its a draggable object (small ball)
        //earth- target, where we want to drop draggable object (big ball)
        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);
        //@param source eleement to emulate button down at.
        //@param target element to move to and release the mouse at.
        actions.dragAndDrop(moon, earth).pause(200).build().perform();
        BrowserUtils.wait(3);

        driver.quit();
    }
}
