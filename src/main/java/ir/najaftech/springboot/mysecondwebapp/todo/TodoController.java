package ir.najaftech.springboot.mysecondwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@RequestMapping(path = "list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findAllByUsername(getLoggedInUsername());
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(path = "add-todo", method = RequestMethod.GET)
	public String todoEditor(ModelMap model) {
			String username = getLoggedInUsername();
			Todo todo = new Todo(0, username, "Guten Tag!", LocalDate.now(), true);
			model.put("todo", todo);
			return "todoEditor";
		}
	
	@RequestMapping(path = "add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todoEditor";
		}
		String username = getLoggedInUsername();
		todoService.saveNewTodo(username, todo.getDescription(), todo.getTargetDate() , false);
		return "redirect:list-todos";	
	}
	
	@RequestMapping(path= "delete-todo")
	public String deleteTodo(@RequestParam int id) throws ClassNotFoundException {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}	
	
	@RequestMapping(path = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todoEditor";
	}
	
	@RequestMapping(path = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@RequestParam int id,ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todoEditor";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoService.updateTodo(id, todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
