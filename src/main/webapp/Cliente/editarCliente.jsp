<%@page import="com.jacaranda.repository.DbRepository"%>
<%@page import="com.jacaranda.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	
	<%
	Cliente cliente = null;
	String msg = "";
	String cadena = "Confirmar";
	String mensaje = request.getParameter("edit")==null?"Editar":cadena;
	try{
		
		String idCliente = (String) (session.getAttribute("idCliente"));
		cliente = DbRepository.findInt(Cliente.class, Integer.valueOf(idCliente));
		
		if(request.getParameter("edit")!=null){
			try{
				if (request.getParameter("edit").equals("Editar")){
					String nombreCliente = request.getParameter("nombreCliente");
					String apellidoCliente = request.getParameter("apellidoCliente");
					String emailCliente = request.getParameter("emailCliente");
					cliente = new Cliente(Integer.valueOf(idCliente), nombreCliente, apellidoCliente, emailCliente);
				}else if(request.getParameter("edit").equals(cadena)) {
					String nombreCliente = request.getParameter("nombreCliente");
					String apellidoCliente = request.getParameter("apellidoCliente");
					String emailCliente = request.getParameter("emailCliente");
					cliente = new Cliente(Integer.valueOf(idCliente), nombreCliente, apellidoCliente, emailCliente);
					DbRepository.update(cliente);
					msg = "Editado con éxito";
				}		
			}catch(Exception e){
				msg = e.getMessage();
			}
		}
	}catch(Exception e){
		
	}
	
	
	%>
	
	<form>
			<div class="mb-3">
	        	<label for="exampleInputEmail1" class="form-label">Nombre</label>
	        	<input type="text" class="form-control" name="nombreCliente" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= cliente.getNombreCliente()%>">
	    	</div>
	    	<div class="mb-3">
	        	<label for="exampleInputPassword1" class="form-label">Apellidos</label>
	        	<input type="text" class="form-control" name="apellidoCliente" id="exampleInputPassword1" value="<%= cliente.getApellido() %>">
	    	</div>
	    	<div class="mb-3">
	        	<label class="form-check-label" for="exampleCheck1">Email</label>
	        	<input type="email" class="form-control" name="emailCliente" id="exampleCheck1" value="<%= cliente.getEmail() %>">
	    	</div>
		
		
			<button type="submit" class="btn btn-primary" name="edit" value="<%= mensaje %>"><%= mensaje %></button>
		</form>
		
		<div>
			<h2><%= msg %></h2>
		</div>
		
</body>
</html>