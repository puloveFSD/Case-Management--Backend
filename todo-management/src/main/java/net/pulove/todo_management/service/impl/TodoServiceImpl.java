package net.pulove.todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.pulove.todo_management.dto.TodoDto;
import net.pulove.todo_management.entity.Todo;
import net.pulove.todo_management.exception.ResourceNotFoundException;
import net.pulove.todo_management.repository.TodoRepository;
import net.pulove.todo_management.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert Todo DTO into Todo JPA
//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        Todo todo = modelMapper.map(todoDto, Todo.class);
        //Calculate extraction duration in minutes:
     if(todo.getExtractionStartTime()!=null && todo.getExtractionEndTime()!=null){
         long duration = Duration.between(todo.getExtractionStartTime(), todo.getExtractionEndTime()).toMinutes();
         todo.setExtractionDuration(duration);
     }

     //calculate import duration in minutes
        if(todo.getImportStartTime()!=null && todo.getImportEndTime()!=null){
            long durationImport= Duration.between(todo.getImportStartTime(), todo.getImportEndTime()).toMinutes();
            todo.setImportDuration(durationImport);
        }

        //calculate report duration in minutes
        if(todo.getImportStartTime()!=null && todo.getImportEndTime()!=null){
            long durationReport = Duration.between(todo.getReportStartDate(), todo.getReportEndDate()).toMinutes();
            todo.setReportDuration(durationReport);
        }

        todo.setTotalTimeDuration(todo.getExtractionDuration()+todo.getImportDuration()+todo.getReportDuration());
        //save todo jpa entity
        Todo savedTodo= todoRepository.save(todo);

        //convert saved Todo Jpa entity into TodoDto object
//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setTitle(savedTodo.getTitle());
//        savedTodoDto.setDescription(savedTodo.getDescription());
//        savedTodoDto.setCompleted(savedTodo.isCompleted());
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);


        return savedTodoDto;
    }


    @Override
    public List<TodoDto> getTodos() {

        List<Todo> listOfTodo=todoRepository.findAll();
        return listOfTodo.stream().map((todo)->modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {

        Todo todo=todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo not found for id:"+id));

        todo.setCaseTitle(todoDto.getCaseTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo  updatedTodo=todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);


    }

    @Override
    public void deleteTodoById(Long id) {
        Todo todo= todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("todo not found for id:"+id));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Todo not found for id:"+id));
        todo.setCompleted(Boolean.FALSE);
        Todo updatedIncompleteTodo=todoRepository.save(todo);
        return modelMapper.map(updatedIncompleteTodo, TodoDto.class);



    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo= todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo not found for id:"+id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo= todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);

    }

    @Override
    public TodoDto getTodoById(Long id) {

        Todo todo= todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo not found with id: "+id));
        return modelMapper.map(todo, TodoDto.class);

    }
}
