package demo.proto.springbootapi.domain.todos;

import demo.proto.springbootapi.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Todos extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String todo;

    @Column(length = 500, nullable = false) // columnDefinition = "TEXT"
    private String memo;

    @Builder
    public Todos(String todo, String memo) {
        this.todo = todo;
        this.memo = memo;
    }

    public void update(String todo, String memo){
        this.todo = todo;
        this.memo = memo;
    }

}
