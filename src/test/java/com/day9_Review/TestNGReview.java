package com.day9_Review;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGReview {
    private WebDriver driver;

    //whatever is common among tests, can go to into @beforemethod and @aftermethod
    //it helps to reduce code duplication
    @BeforeMethod
    public void setup() {
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After method!");
        driver.quit();
    }

    @Test(description = "Verify title of google.com", priority = 2)
    public void test1() {
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");
    }

    //priority will change the order of test execution
    //by default tests are running in alphabetic order
    //lower priority - earlier execution
    @Test(description = "Verify title of apple.com", priority = 1)
    public void verifyApplesPageTitle() {
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        //message will be printed only if assertion failed
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");
        //if assertion passed, you will see message from line below
        //if assertion passed, you will see message from line below
    }
        //date provider can supply test with a test data. Also, it allos to do Data driven testing.
        //what is this? its when same test runs multiple times with a different test data set
        @DataProvider(name = "testData")
        public Object[][] testData(){
            return new Object[][]
            {
                    {"http://apple.com", "Apple"},
                {"http://google.com", "Google"}
            };
        }




//    @Test(dataProvider = ("testData")
//    public void testWithDataProvider(String url, String title) {
//        driver.get(url);
//        Assert.assertEquals(driver.getTitle(), title);
//    }
}