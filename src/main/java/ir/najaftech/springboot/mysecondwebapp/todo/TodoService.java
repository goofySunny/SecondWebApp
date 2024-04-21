package ir.najaftech.springboot.mysecondwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private final TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

//	private static List<Todo> todos = new ArrayList<>();
//	private static int idCounter = 0;
//	static {
//		todos.add(new Todo(++idCounter, "najaf", "Learn AWS", LocalDate.now().plusYears(1), false));
//		todos.add(new Todo(++idCounter, "najaf", "Learn DevOps", LocalDate.now().plusYears(1), false));
//		todos.add(new Todo(++idCounter, "najaf", "FullStack development", LocalDate.now().plusDays(40), false));
//	}
	
	
	public List<Todo> findAllByUsername(String username) {
//		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
//		return todos.stream().filter(predicate).toList();
		return todoRepository.findAllByUsername(username);
	}
	
	public void saveNewTodo(String username, String desc, LocalDate targetDate, boolean done) {
//		todos.add(new Todo(++idCounter, username, desc, targetDate, done));
		Todo todo = new Todo(username, desc, targetDate, done);
		todoRepository.save(todo);
	}
	
	public void deleteTodoById (long id) throws ClassNotFoundException {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		todos.removeIf(predicate);
		todoRepository.deleteById(id);
	}
	
	public Todo findById(long id) {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		return todos.stream().filter(predicate).findFirst().get();
		return todoRepository.findById(id).get();
	}
	
	public void updateTodo(int id, Todo todo) {
		Todo targetedTodo = findById(id);
		targetedTodo.setDescription(todo.getDescription());
		targetedTodo.setTargetDate(todo.getTargetDate());
		targetedTodo.setDone(todo.isDone());
		targetedTodo.setUsername(todo.getUsername());
		todoRepository.save(targetedTodo);
		
	}
	
	
	
	
	
	
	
}
