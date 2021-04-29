package com.mucahit.junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AarayCompareTest.class, BeforeAfterTest.class, StringHelperTest.class})
public class AllTests {
}
