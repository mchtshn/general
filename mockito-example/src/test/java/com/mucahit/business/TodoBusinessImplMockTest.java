package com.mucahit.business;

import com.mucahit.data.api.TodoBusinessImpl;
import com.mucahit.data.api.TodoService;
import com.mucahit.data.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrievedTodosRelatedToSpring_UsingAMock() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }


    @Test
    public void testRetrievedTodosRelatedToSpring_UsingBDD() {

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));


    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD() {

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRelatedSpring("Dummy");

        //Then
        //deleteTodo("Learn to Dance") should be called 1 times
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        //deleteTodo("Learn Spring") should never be called
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");
        //deleteTodo("Learn Spring MVC") should never be called
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");


    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD_Version2() {

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRelatedSpring("Dummy");

        //Then
        //deleteTodo("Learn to Dance") should be called
        then(todoServiceMock).should().deleteTodo("Learn to Dance");

        //deleteTodo("Learn Spring") should never be called
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
        //deleteTodo("Learn Spring MVC") should never be called
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");


    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD_argumentCapture() {

        //declare argument captor
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRelatedSpring("Dummy");

        //Then
        //deleteTodo("Learn to Dance") should be called
        then(todoServiceMock).should().deleteTodo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Learn to Dance"));

    }
}
