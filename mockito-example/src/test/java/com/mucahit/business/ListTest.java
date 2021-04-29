package com.mucahit.business;

import org.junit.Test;
import org.mockito.BDDMockito;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {


    @Test
    public void letsMockListSize() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());

    }

    @Test
    public void letsMockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());

    }

    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);

        when(listMock.get(0)).thenReturn("Mücahit");

        assertEquals("Mücahit", listMock.get(0));
        assertNull(listMock.get(1));

    }

    @Test
    public void letsMockListGetAnyMatcher() {
        List listMock = mock(List.class);

        //argument matcher
        when(listMock.get(anyInt())).thenReturn("Mücahit");

        assertEquals("Mücahit", listMock.get(0));
        assertEquals("Mücahit", listMock.get(1));

    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_ThrowAnException() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(0);

    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_MixingUp() {
        List listMock = mock(List.class);

        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));


    }

    @Test
    public void letsMockListGet_UsingBDD() {

        //Given
        List<String> listMock = mock(List.class);

        BDDMockito.given(listMock.get(0)).willReturn("Mücahit");

        //When
        String firstElement = listMock.get(0);

        //That
        assertThat(firstElement, is("Mücahit"));
        assertNull(listMock.get(1));

    }

}
