package fr.keyce.todo_list.dao;

import java.util.List;

import fr.keyce.todo_list.model.Todo;

public interface TodoDao {
	public List<Todo> findAll();
	public void delete(Integer id);
	public Todo update(Todo todo);
	public Todo create(Todo todo);
}
