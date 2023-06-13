<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fr.keyce.todo_list.model.Todo"%>
<%@page import="java.util.Map"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TodoList</title>
		<link href="../css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div>
			<h1>TodoList</h1><hr/>
			
			<div class="add-button">
				<c:url var="todoCreateUrl" value="/TodoCreate"/>
				<a href="${todoCreateUrl}">Ajouter</a>
			</div>
		
			<c:forEach items="${getAllTodo}" var="todo">
				<div class="todo-list">
    				<div class="todo-item">
						<form method="post" action="http://localhost:8080/todo-list/TodoList">
							<h2>Todo ${todo.getId()}</h2>
							<input type="text" id="id" name="id" value="${todo.getId()}" hidden="true">
						
							<label for="name">Nom:</label>
							<input type="text" id="name" name="name" value="${todo.getName()}"><br/><br/>
					 		
					 		<label for="description">Description:</label>
							<input type="text" id="description" name="description" value="${todo.getDescription()}"><br/><br/>
							
							<label for="creationDate">Date de création:</label>
							${todo.getCreationDate()}<br/><br/>
							
							<label for="deadLine">Dead line :</label>
							<input type="text" id="deadLine" name="deadLine" value="${todo.getDeadLine()}"><br/><br/>
							
							<label for="priority">Priorité :</label>
							${todo.getPriority()}
							<select id="priority" name="priority">
								<option value="none" selected>Select an Option</option>
								<option value="LOW">Low</option>
								<option value="NORMAL">Normal</option>
								<option value="HIGH">High</option>
							</select>
					 		<div class="buttons">
								<input type="submit" name="action" value="Modifier">
							</div>
						</form>
						
					 	<form method="post" action="http://localhost:8080/todo-list/TodoList">
							<input type="hidden" name="id" value="${todo.getId()}">
							<div class="buttons">
								<input type="submit" name="action" value="Supprimer">
							</div>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</body>
	<style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #202020;
    }
    
    h1 {
      text-align: center;
      color: white;
    }
    
    .todo-item {
      margin-bottom: 10px;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #f5f5f5;
    }
    
    .todo-item h2 {
      margin-top: 0;
    }
    
    .todo-item p {
      margin: 0;
    }
    
    .todo-item .buttons {
      margin-top: 10px;
    }
    
    .todo-item .buttons button {
      margin-right: 5px;
    }
    
    .add-button {
      text-align: center;
      margin-bottom: 20px;
    }
    
    .add-button a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
    }
  </style>
</html>