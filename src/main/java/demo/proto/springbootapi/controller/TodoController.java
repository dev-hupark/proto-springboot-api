package demo.proto.springbootapi.controller;

import demo.proto.springbootapi.model.TodoVO;
import demo.proto.springbootapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<TodoVO>> getTodos() {
        List<TodoVO> todos = todoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(todos);

    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<TodoVO> getTodoById(@PathVariable("id") long id) {
        Optional<TodoVO> todos = todoService.findById(id);
        return new ResponseEntity<TodoVO>(todos.get(), HttpStatus.OK);
    }
}
