package com.todo;

import com.todo.util.Priority;

public class ToDo {
	
	private Integer id;
	private Priority priority;
	private String todo;
	
	public ToDo() {}
	
	public ToDo(Integer id, Priority priority, String todo) {
		super();
		this.id = id;
		this.priority = priority;
		this.todo = todo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = Priority.valueOf(priority);
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
}
