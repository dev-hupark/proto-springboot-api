package demo.proto.springbootapi.model;

import demo.proto.springbootapi.domain.todos.Todos;
import lombok.Getter;

@Getter
public class TodoResDto {
    private Long id;
    private String todo;
    private String memo;

    public TodoResDto(Todos entity){
        this.id = entity.getId();
        this.todo = entity.getTodo();
        this.memo = entity.getMemo();
    }
}
