package com.mucahit.junit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AarayCompareTest {


    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 1000)
    public void testSort_Performance() {

        int[] array = {12, 23, 4};
        for (int i = 0; i <= 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }


}
