package com.cbt.utilities;

public class StringUtility {
    public static void verifyEquals (String expected, String actual ) {



        if (expected.equals(actual)) {

            System.out.println("PASS");

            System.out.println("Expected result is "+expected);

            System.out.println("Actual result is "+actual);



        } else {

            System.out.println("FAIL");

            System.out.println("Expected result is "+expected);

            System.out.println("Actual result is "+actual);

        }



    }
}
