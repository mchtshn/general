package com.mucahit.junit;

import org.junit.*;


public class BeforeAfterTest {

    //testlerden önce sadece bi kere çalışır.
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    //her testten önce çalışır
    @Before
    public void setup() {
        System.out.println("before test executed");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    //her testten sonra çalışır
    @After
    public void teardown() {
        System.out.println("after test executed");
    }

    //testlerden sonra sadece bi kere çalışır.
    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }
}
