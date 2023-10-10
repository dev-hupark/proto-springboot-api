package demo.proto.springbootapi.domain.todos;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodosRepositoryTest {

    @Autowired
    TodosRepository todosRepository;

    @After
    public void cleanup(){
        todosRepository.deleteAll();
    }

    @Test
    public void getTodos() {
        String todo = "todo title";
        String memo = "todo memo";

        todosRepository.save(Todos.builder()
                        .todo(todo)
                        .memo(memo)
                        .build());

        List<Todos> todosList = todosRepository.findAll();

        Todos todos = todosList.get(0);

        assertThat(todos.getTodo()).isEqualTo(todo);
        assertThat(todos.getMemo()).isEqualTo(memo);
    }

    @Test
    public void BaseTimeEntity_init() {
        LocalDateTime now = LocalDateTime.of(2023,10,4,0,0,0);
        todosRepository.save(Todos.builder()
                        .todo("todo1")
                        .memo("memo1")
                        .build());

        List<Todos> todosList = todosRepository.findAll();

        Todos todos = todosList.get(0);

        System.out.println(">>>>>>>>> create dt = " + todos.getCreatedDate() + ", modify dt = " + todos.getModifiedDate());

        assertThat(todos.getCreatedDate()).isAfter(now);
        assertThat(todos.getModifiedDate()).isAfter(now);
    }
}
