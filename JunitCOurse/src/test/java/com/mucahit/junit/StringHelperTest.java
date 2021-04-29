package com.mucahit.junit;


import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {

    StringHelper helper;

  /*  @Before
    public void beforeTest(){
        helper=new StringHelper();
    }*/


    @Test
    public void truncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();

        //AACD -> CD
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));

        //ACD -> CD
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));

        //ACDAA -> CDAA
        assertEquals("CDAA", helper.truncateAInFirst2Positions("ACDAA"));

    }

    @Test
    public void areFirstandLastTwoCharactersTheSame() {
        StringHelper helper = new StringHelper();

        //ABCD
        boolean actualValue = helper.areFirstandLastTwoCharactersTheSame("ABCD");
        boolean expectedValue = false;
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void areFirstandLastTwoCharactersTheSame_Version2() {
        StringHelper helper = new StringHelper();

        assertTrue(helper.areFirstandLastTwoCharactersTheSame("ABAB"));
        //assertFalse(helper.areFirstandLastTwoCharactersTheSame("ABCD"));
    }


}