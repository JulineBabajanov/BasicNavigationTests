package day7;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsTest {
    @BeforeMethod
    public void setup(){
        //some code that will be running before every test, like: test1, test2, test3
        //we can use method with @BeforeMethodannotation
        System.out.println("Before method!");
    }
    @Test
    public void test1() {
        System.out.println("Test 1!");
    }
        @Test
        public void test2() {
            System.out.println("Test 2!");
        }
            @Test
            public void test3() {
                System.out.println("Test 3!");
            }
    }



