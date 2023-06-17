package demo.proto.springbootapi.service;

import demo.proto.springbootapi.Repository.TodoRepository;
import demo.proto.springbootapi.model.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoVO> findAll(){
        List<TodoVO> todos = new ArrayList<>();
        todoRepository.findAll().forEach(e -> todos.add(e));

        return todos;
    }

    public Optional<TodoVO> findById(long id){
        Optional<TodoVO> todo = todoRepository.findById(id);
        return todo;
    }
}
