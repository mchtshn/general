package com.mucahit.business;

import com.mucahit.data.api.TodoBusinessImpl;
import com.mucahit.data.api.TodoService;
import com.mucahit.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrievedTodosRelatedToSpring_UsingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }

}
