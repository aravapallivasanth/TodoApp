package com.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	public List<ToDo> toDoList = new ArrayList<>(); 
		
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@ResponseBody
	public List<ToDo> saveTodo(@RequestBody ToDo todo) {		
		toDoList.add(todo);
		System.out.println("---saveTodo---"+toDoList.size());
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTodoList")
	public List<ToDo> getTodoList() {
		System.out.println("---getTodoList---"+toDoList.size());
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateTodoItem")
	public List<ToDo> updatePriority(@RequestBody ToDo todoObj) {		
		toDoList.stream().forEach( todo -> { if (todo.getId().equals(todoObj.getId())) 
			todo.setPriority(todoObj.getPriority().toString());
			todo.setTodo(todoObj.getTodo());
		});	
		System.out.println("---updateTodoList---"+toDoList.size());
		return toDoList;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTodoItem")
	public List<ToDo> deleteTodoListItem(@RequestParam Integer id) {
		toDoList.removeIf(todo -> todo.getId().equals(id));	
		System.out.println("---deleteTodoListItem---"+toDoList.size());
		return toDoList;
	}
}
