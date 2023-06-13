package fr.keyce.todo_list.services.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.keyce.todo_list.dao.TodoDao;
import fr.keyce.todo_list.dao.db.TodoDaoDb;
import fr.keyce.todo_list.model.Priority;
import fr.keyce.todo_list.model.Todo;
import fr.keyce.todo_list.services.TodoService;

public class TodoServiceImpl implements TodoService {

	private final static TodoServiceImpl INSTANCE = new TodoServiceImpl();

	private TodoServiceImpl() {};

	public static TodoServiceImpl getInstance() {
		return INSTANCE;
	}

	private TodoDao todoDao = TodoDaoDb.getInstance();

	@Override
	public List<Todo> findAll() {
		return this.todoDao.findAll();
	}

	@Override
	public void delete(Integer id) {
		this.todoDao.delete(id);
	}

	@Override
	public Todo update(Todo todo) {
		return this.todoDao.update(todo);
	}

	@Override
	public Todo create(Todo todo) {
		return this.todoDao.create(todo);
	}

	@Override
	public Todo update(HttpServletRequest request) throws ParseException, NumberFormatException, IllegalArgumentException {
		Todo update = new Todo();
		update.setId(Integer.parseInt(request.getParameter("id")));
		update.setName(request.getParameter("name"));
		update.setDescription(request.getParameter("description"));
		update.setDeadLine(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("deadLine"))); 
		update.setPriority(Priority.valueOf(request.getParameter("priority")));
		return update;
	}
	
	@Override
	public Todo create(HttpServletRequest request) throws ParseException, NumberFormatException, IllegalArgumentException {
		Todo create = new Todo();
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String deadLine = request.getParameter("deadLine");
		String priority = request.getParameter("priority");
		
		checkString(name);
		checkString(description);
		checkDate(deadLine);
		checkPriority(priority);

		create.setId(1);
		create.setName(name);
		create.setDescription(description);
		create.setCreationDate(new Date());
		create.setDeadLine(new SimpleDateFormat("dd/MM/yyyy").parse(deadLine)); 
		create.setPriority(Priority.valueOf(priority));
		return create;
	}
	
	private void checkDate(String date) {
		Pattern.matches("^(0?[1-9]|[1-2][0-9]|3[0-1])/(0?[1-9]|1[0-2])/\\d{4}$", date);
	}
	
	private void checkString(String string) {
		Pattern.matches("^[a-zA-Z0-9 ,.;:!/\\\\$*^¨]+$", string);
	}
	
	private void checkPriority(String priority) {
		Pattern.matches("^\b(?:LOW|NORMAL|HIGH)\b$", priority);
	}
}