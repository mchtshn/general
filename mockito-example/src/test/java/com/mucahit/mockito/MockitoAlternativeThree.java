package com.mucahit.mockito;

import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoAlternativeThree {

    // we can use a MockitoJUnit.rule() as shown below:
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
}
