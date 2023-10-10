package demo.proto.springbootapi.Repository;

import demo.proto.springbootapi.domain.todos.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long> {
    public Optional<Todos> findById(long id);
    // public List<TodoVO> findByName(String name);
    //like검색도 가능
    // public List<TodoVO> findByNameLike(String keyword);
}
