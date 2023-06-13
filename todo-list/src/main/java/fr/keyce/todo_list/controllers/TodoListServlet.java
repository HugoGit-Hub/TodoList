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

@WebServlet(name = "TodoListServlet", urlPatterns = "/TodoList")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodoService todoService = TodoServiceImpl.getInstance();
	private final String REDIRECT_URL = "http://localhost:8080/todo-list/TodoList";
	private final String PATH_REQUEST_DISPATCHER = "/jsp/todoList.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("getAllTodo", this.todoService.findAll());
		request.getRequestDispatcher(PATH_REQUEST_DISPATCHER).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("action")) {
			case "Supprimer": {
				todoService.delete(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect(REDIRECT_URL);
				break;
			}
			case "Modifier":{
				Todo update;
				try {
					update = this.todoService.update(request);
					todoService.update(update);
				} catch (ParseException | IllegalArgumentException e) { // Gère aussi la NumberFormatException
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

				response.sendRedirect(REDIRECT_URL);
				break;
			}
		}
	}

	
}