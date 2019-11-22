package day10;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }
    @Test(description = "Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("file Upload")).click();
        //provide path
        //insert your path to the file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\JBABA\\OneDrive\\Desktop\\ron-patton-software-testing-1st-edition.pdf");
        //if you have one back slash then it should have two and be doubled. or put just one forward slash only
        //click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "ron-patton-software-testing-1st-edition.pdf";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, expectedFileName);

    }
    @AfterMethod
    public void teardown(){
        
    driver.quit();
}
}
