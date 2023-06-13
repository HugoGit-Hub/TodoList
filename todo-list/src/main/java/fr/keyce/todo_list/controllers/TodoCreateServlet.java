package fr.keyce.todo_list.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.keyce.todo_list.model.Todo;
import fr.keyce.todo_list.services.TodoService;
import fr.keyce.todo_list.services.Impl.TodoServiceImpl;

@WebServlet(name = "TodoCreateServlet", urlPatterns = { "/TodoCreate" })
public class TodoCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private TodoService service = TodoServiceImpl.getInstance();
    private final String REDIRECT_URL = "http://localhost:8080/todo-list/TodoList";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/todoCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Todo create;
		try {
			create = this.service.create(request);
			service.create(create);
		} catch (ParseException | IllegalArgumentException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}                                                                                                                                                                                                                                                                		

		response.sendRedirect(REDIRECT_URL);
	}
}
