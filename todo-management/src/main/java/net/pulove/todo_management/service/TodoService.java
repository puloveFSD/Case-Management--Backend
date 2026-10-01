package net.pulove.todo_management.service;

import net.pulove.todo_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodoById(Long id);

    List<TodoDto> getTodos();

    TodoDto updateTodo(Long id, TodoDto todoDto);

    void deleteTodoById(Long id);

    TodoDto completeTodo(Long id);

    TodoDto inCompleteTodo(Long id);
}