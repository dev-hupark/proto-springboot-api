package demo.proto.springbootapi.model;

import demo.proto.springbootapi.domain.todos.Todos;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoListResDto {
    private Long id;
    private String todo;
    private String memo;
    private LocalDateTime modifiedDate;

    public TodoListResDto(Todos entity){
        this.id = entity.getId();
        this.todo = entity.getTodo();
        this.memo = entity.getMemo();
        this.modifiedDate = entity.getModifiedDate();
    }
}
