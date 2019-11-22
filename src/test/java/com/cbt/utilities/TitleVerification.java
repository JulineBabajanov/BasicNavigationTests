package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



public class TitleVerification {

    public static void main(String[] args) throws Throwable {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",

                "http://practice.cybertekschool.com/dropdown",

                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        ArrayList<String> tittlesResult = new ArrayList();

        String expected = "";



        for (int i =0; i <urls.size(); i++) {

            driver.get(urls.get(i));

            expected = driver.getTitle();



            if (expected.equals(driver.getTitle())) {

                tittlesResult.add("Passed");

            } else {

                tittlesResult.add("Failed");

            }

        }

        System.out.println(tittlesResult);

        driver.close();

    }



}


