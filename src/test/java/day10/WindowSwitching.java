package day10;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
     @Test (description = "Verify that titile is still Practice")
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds, another website will be opened in the second window
         //selenium doesnt switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
         Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong!");
    }
    @Test (description = "Verify that user is able to see new window")
    public void test2(){
        driver.findElement(new By.ByLinkText("New Tab")).click();
        //record id of original window
        String oldWindow = driver.getWindowHandle();
        //after 3 seconds another web site will be opened, in the second window
        //selenium doesnt switch automatically to the new window
        BrowserUtils.wait(5);
        //in selenium every window has an id. the id calls window handle
        //to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handles
        //list-it's a data structure
        //set its also a data structure like list, but it does not allow duplicates
        //also, you can not easily access anything from there
        //there is no .get() method.
        //thats why, we need to loop through the set, to read a data from there
        // set can store only unique values
        Set<String> windowHandles = driver.getWindowHandles();
        //loop through the collection of window handles
        for(String windowHandle: windowHandles){
            //if its not an old window
            if(!windowHandle.equals(oldWindow)){
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        //lets verify that titale of new window is a FResh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh Tab", "Title is wrong");
        //comeback to original page
        //we can build a function, that will jump, in between windows
        //based on page title we can determine where to stop
        String pageTitle = "Practice"; // title of the page that we want
        for(String windowHandle:windowHandles){
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            // once we found page title, of the window that we need
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
