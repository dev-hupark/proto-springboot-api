package demo.proto.springbootapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateReqDto {
    private String todo;
    private String memo;

    @Builder
    public TodoUpdateReqDto(String todo, String memo){
        this.todo = todo;
        this.memo = memo;
    }
}
