package demo.proto.springbootapi.controller;

import demo.proto.springbootapi.model.TodoResDto;
import demo.proto.springbootapi.model.TodoSaveReqDto;
import demo.proto.springbootapi.model.TodoUpdateReqDto;
import demo.proto.springbootapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/")
    public Long save(@RequestBody TodoSaveReqDto requestDto){
        return todoService.save(requestDto);
    }

    @PutMapping(value = "/{id}")
    public Long update(@PathVariable("id") long id, @RequestBody TodoUpdateReqDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public TodoResDto findById(@PathVariable Long id){
        return todoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }

   /* @RequestMapping(value = "/todos")
    @ResponseBody
    public ResponseEntity<List<TodoSaveReqDto>> getTodos() {
        List<TodoSaveReqDto> todos = todoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(todos);

    }

    @RequestMapping(value = "/todos/{id}")
    @ResponseBody
    public ResponseEntity<TodoSaveReqDto> getTodoById(@PathVariable("id") long id) {
        Optional<TodoSaveReqDto> todos = todoService.findById(id);
        return new ResponseEntity<TodoSaveReqDto>(todos.get(), HttpStatus.OK);
    }*/
}
