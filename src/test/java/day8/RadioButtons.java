package day8;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtons {
   private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test
    public void test1(){
        //go to radio buttons
     driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton = driver.findElement(By.id("blue"));
        //find blue radio button
        //lets verify that radio button is selected
        Assert.assertTrue(blueButton.isSelected());
    }
    @Test (description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected()); //assrtFalse will expect that condition is false

    }
@Test(description = "Verify that green button is not clickable")
public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
        //isEnabled() will return true if button is available for interaction
    //that means you can click on it, in this case
}
//lets find all radio buttons and click on them one by one
    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all radio buttons
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        //lets clik only if button is not clicked and is available for clicking
        for(WebElement button: radioButtons){
            if(button.isEnabled() && !button.isSelected()) {
                //then click on it
                button.click();
                //in this case, id attribute represents a name of the color
                //also, there is no text in this element
                //thats why i print attribute value
                // <input type ="radio" id="green" name="color"
                System.out.println("Button clicked: " + button.getAttribute("id"));
            }else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
                BrowserUtils.wait(1);
            }
        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();



    }
}