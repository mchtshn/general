package com.mucahit.junit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(Parameterized.class)
class StringHelperParameterizedTest {
    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedOutputs = {{"AACD", "CD"}, {"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }


    @Test
    void truncateAInFirst2Positions() {
        //AACD -> CD
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));

    }

    @Test
    void truncateAInFirst2Positions2() {
        //ACD -> CD
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));

    }

    @Test
    void areFirstandLastTwoCharactersTheSame() {

        //ABCD
        boolean actualValue = helper.areFirstandLastTwoCharactersTheSame("ABCD");
        boolean expectedValue = false;
        assertEquals(expectedValue, actualValue);

    }

    @Test
    void areFirstandLastTwoCharactersTheSame_Version2() {
        assertTrue(helper.areFirstandLastTwoCharactersTheSame("ABCD"));
        //assertFalse(helper.areFirstandLastTwoCharactersTheSame("ABCD"));
    }


}