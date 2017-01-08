package com.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	public List<ToDo> toDoList = new ArrayList<>(); 
		
	@RequestMapping(method = RequestMethod.POST, value = "/save")	
	public List<ToDo> saveTodo(@RequestBody ToDo todo) {		
		toDoList.add(todo);
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTodoList")
	public List<ToDo> getTodoList() {		
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateTodoItem")
	public List<ToDo> updatePriority(@RequestBody ToDo todoObj) {		
		toDoList.stream().forEach( todo -> { if (todo.getId().equals(todoObj.getId())) 
			todo.setPriority(todoObj.getPriority().toString());
			todo.setTodo(todoObj.getTodo());
		});	
		
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTodoItem")
	public List<ToDo> deleteTodoListItem(@RequestParam Integer id) {
		toDoList.removeIf(todo -> todo.getId().equals(id));			
		return toDoList;
	}
}
