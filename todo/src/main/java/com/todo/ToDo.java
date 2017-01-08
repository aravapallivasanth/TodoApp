package com.todo;

import com.todo.util.Priority;

public class ToDo {
	
	private Integer id;
	private Priority priority;
	private String todo;
	
	public ToDo() {}
	
	public ToDo(Integer id, Priority priority, String todo) {		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((todo == null) ? 0 : todo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priority != other.priority)
			return false;
		if (todo == null) {
			if (other.todo != null)
				return false;
		} else if (!todo.equals(other.todo))
			return false;
		return true;
	}
}
