package com.mucahit.mockito;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class MockitoALternativeTwo {

    //we can enable Mockito annotations programmatically as well, by invoking MockitoAnnotations.initMocks():

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
