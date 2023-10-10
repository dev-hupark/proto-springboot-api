package demo.proto.springbootapi.service;

import demo.proto.springbootapi.domain.todos.Todos;
import demo.proto.springbootapi.domain.todos.TodosRepository;
import demo.proto.springbootapi.model.TodoListResDto;
import demo.proto.springbootapi.model.TodoResDto;
import demo.proto.springbootapi.model.TodoSaveReqDto;
import demo.proto.springbootapi.model.TodoUpdateReqDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodosRepository todosRepository;

    @Transactional
    public Long save(TodoSaveReqDto requestDto){
        return todosRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, TodoUpdateReqDto requestDto){
        Todos todos = todosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메모가 없습니다. id="+id));

        todos.update(requestDto.getTodo(), requestDto.getMemo());

        return id;
    }

    public TodoResDto findById(Long id) {
        Todos entity = todosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메모가 없습니다. id="+id));
        return new TodoResDto(entity);
    }

    @Transactional
    public List<TodoListResDto> findAllDesc() {
        return todosRepository.findAllDesc().stream().map(TodoListResDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Todos todos = todosRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 메모가 없습니다. id = " + id));

        todosRepository.delete(todos);
    }

    /*public List<TodoSaveReqDto> findAll(){
        List<TodoSaveReqDto> todos = new ArrayList<>();
        todoRepository.findAll().forEach(e -> todos.add(e));

        return todos;
    }

    public Optional<TodoSaveReqDto> findById(long id){
        Optional<TodoSaveReqDto> todo = todoRepository.findById(id);
        return todo;
    }*/
}
