package fr.keyce.todo_list.model;

import java.util.Date;

public class Todo {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Date creationDate;
	
	private Date deadLine;
	
	private Priority priority;	

	public Todo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public final static Todo create(Integer id, String name, String description, Date creationDate, Date deadLine, Priority priority) {
		Todo todo = new Todo();
		todo.id = id;
		todo.name = name;
		todo.description = description;
		todo.creationDate = creationDate;
		todo.deadLine = deadLine;
		todo.priority = priority;
		return todo;
	}
}
