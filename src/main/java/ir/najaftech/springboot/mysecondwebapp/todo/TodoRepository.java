package ir.najaftech.springboot.mysecondwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findAllByUsername(String username);
	
}
