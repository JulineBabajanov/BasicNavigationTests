package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



public class TitleVerification2 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",

                "https://walmart.com", "https://westelm.com/");



        ArrayList<String> titleResult = new ArrayList<String>();

        for (int i =0; i <urls.size(); i++) {

            driver.get(urls.get(i));



            String url = driver.getCurrentUrl();



            String title = driver.getTitle().toLowerCase().replaceAll(" ","");



            if (url.contains(title)) {

                titleResult.add("This "+ url +" contains title of "+ title);

            } else {

                titleResult.add("This "+ url +" doesn't contains title of "+title);

            }



        }

        System.out.println(titleResult);

        driver.close();

















    }

}
