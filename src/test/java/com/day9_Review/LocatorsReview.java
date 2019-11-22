package com.day9_Review;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsReview {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }
    //we have id, name tag, class name, link text, partial link text, xpath, css selector
    @Test(description = "Verify checkboxes")
    public void test1() {
        driver.findElement(By.linkText("Checkboxes")).click();
        //[type='checkbox'} since there are 2 elements with a same locator
        // and I need only first one, I can use in css, :nth-of-type(index) 7th, 8th etc
        //its very useful if you have more than one element under same css selector
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox':nth-of-type(1)"));
        //how to verify if check box is not clicked?
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 was selected");//assert that check box is not selected
        //[index]= to specify index of the element, if there are multiple elements with this x path
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 was not selected");
        // again, css selector is preferable, bc of speed
        //assertion is like if statement
        //if(true){
        //"test passed"
        //}else{
        //"test failed"
        // throw new Runtime Exception ("EXception
    }
    }
//    @Test(description = "Radio buttons test")
//
//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }
//    }

