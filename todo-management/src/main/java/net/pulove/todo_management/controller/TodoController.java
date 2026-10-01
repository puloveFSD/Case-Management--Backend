package net.pulove.todo_management.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.pulove.todo_management.dto.TodoDto;
import net.pulove.todo_management.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //Build Add ToDo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo=todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id")Long id){
        TodoDto todoDto=todoService.getTodoById(id);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todoDtos=todoService.getTodos();
        return ResponseEntity.ok(todoDtos);

    }
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDto todoDto ) {
        TodoDto updatedTodo= todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodoById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto>completeTodo(@PathVariable("id") Long id){
        TodoDto updatedTodo=todoService.completeTodo(id);
        return ResponseEntity.ok(updatedTodo);
    }
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto>inCompleteTodo(@PathVariable("id") Long id){
        TodoDto updatedTodoIncomplete=todoService.inCompleteTodo(id);
        return ResponseEntity.ok(updatedTodoIncomplete);
    }
}
