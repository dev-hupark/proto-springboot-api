package demo.proto.springbootapi.domain.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    @Query("SELECT t FROM Todos t order by t.id desc")
    List<Todos> findAllDesc();
}
