package demo.proto.springbootapi.model;

import demo.proto.springbootapi.domain.todos.Todos;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
public class TodoSaveReqDto {

    private String todo;
    private String memo;
    private String status;
    private Date deadlineDt;
    private Date completionDt;
    private String createdUser;
    private Date createdDt;

    @Builder
    public TodoSaveReqDto(String todo, String memo){
        this.todo = todo;
        this.memo = memo;
    }

    public Todos toEntity() {
        return Todos.builder()
                .todo(todo)
                .memo(memo)
                .build();
    }
}
