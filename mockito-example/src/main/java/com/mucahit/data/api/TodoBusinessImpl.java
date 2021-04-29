package com.mucahit.data.api;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo : todos) {
            if (todo.contains("Spring"))
                filteredTodos.add(todo);
        }

        return filteredTodos;
    }

    public void deleteTodosNotRelatedSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo : todos) {
            if (!todo.contains("Spring"))
                todoService.deleteTodo(todo);
        }

    }
}
