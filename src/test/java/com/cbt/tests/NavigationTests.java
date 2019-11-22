package com.cbt.tests;


import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        //test("safari");
       // test("firefox");
        test("chrome");
    }

    private static void test(String browser) {
        WebDriver driver = BrowserFactory.getDriver(browser);
        assert driver != null;
        driver.get("http://google.com");
        String title=driver.getTitle();
        driver.navigate().to("http://etsy.com");
        String title2=driver.getTitle();
        driver.navigate().back();
        driver.navigate().back();
        StringUtility.verifyEquals(title, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
        driver.close();
    }


}
