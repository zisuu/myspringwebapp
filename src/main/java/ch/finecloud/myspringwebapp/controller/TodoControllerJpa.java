package ch.finecloud.myspringwebapp.controller;

import ch.finecloud.myspringwebapp.entities.Todo;
import ch.finecloud.myspringwebapp.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private final TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("list-todos")
    public String getListTodosPage(ModelMap modelMap) {
        String username = getLoggedinUsername(modelMap);
        List<Todo> todos = todoRepository.findByUsername(username);
        modelMap.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String getTodoPage(ModelMap modelMap) {
        String username = getLoggedinUsername(modelMap);
        Todo todo = new Todo(
                0,
                username,
                "",
                LocalDate.now(),
                false
        );
        modelMap.put("todo", todo);
        return "repository";
    }

    @PostMapping("add-todo")
    public String saveNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "repository";
        }
        String username = getLoggedinUsername(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodoPage(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String getUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
        Todo todo = todoRepository.findById(id).get();
        modelMap.addAttribute("todo", todo);
        return "repository";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "repository";
        }
        String username = getLoggedinUsername(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedinUsername(ModelMap modelMap) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
