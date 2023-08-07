package ch.finecloud.myspringwebapp.repository;

import ch.finecloud.myspringwebapp.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
