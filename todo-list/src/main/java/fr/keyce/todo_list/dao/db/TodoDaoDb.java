package fr.keyce.todo_list.dao.db;

import java.util.List;

import fr.keyce.todo_list.dao.TodoDao;
import fr.keyce.todo_list.db.Database;
import fr.keyce.todo_list.model.Todo;

public class TodoDaoDb implements TodoDao {

	private final static TodoDaoDb INSTANCE = new TodoDaoDb();
	
	private TodoDaoDb() {};

	public static TodoDaoDb getInstance() {
		return INSTANCE;
	}
	
	private Database database = Database.getInstance();
	
	@Override
	public List<Todo> findAll() {
		return this.database.selectAll();
	}

	@Override
	public void delete(Integer id) {
		this.database.delete(id);
	}

	@Override
	public Todo update(Todo todo) {
		return this.database.update(todo);
	}

	@Override
	public Todo create(Todo todo) {
		return this.database.create(todo);
	}
}
