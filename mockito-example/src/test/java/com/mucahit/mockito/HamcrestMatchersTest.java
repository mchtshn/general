package com.mucahit.mockito;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //scores has 4 items
        assertThat(scores, hasSize(4));

        //scores has ... items
        assertThat(scores, hasItems(100, 101));

        //every item : >90
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(190)));

        //string
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        //arrays
        Integer[] marks = {1, 2, 3};

        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1, 2, 3));
        assertThat(marks, arrayContainingInAnyOrder(3, 1, 2));

    }
}
