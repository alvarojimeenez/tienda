<%@page import="com.jacaranda.repository.DbRepository"%>
<%@page import="java.util.ArrayList"%>
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
<%	ArrayList<Cliente> listaClientes = null;
	try{
		listaClientes = (ArrayList) DbRepository.findAll(Cliente.class);
		
		if (request.getParameter("editar")!=null){
			session.setAttribute("idCliente", request.getParameter("editar"));
			response.sendRedirect("editarCliente.jsp");
		}
		
		if (request.getParameter("borrar")!=null){
			session.setAttribute("idCliente", request.getParameter("borrar"));
			response.sendRedirect("borrarCliente.jsp");
		}
		
		if (request.getParameter("pedidos")!=null){
			session.setAttribute("idCliente", request.getParameter("pedidos"));
			response.sendRedirect("listaPedidosCliente.jsp");
		}
			
		%>
		<table class="table">
	    <thead>
	        <tr>
	            <th scope="col">Id</th>
	            <th scope="col">Nombre</th>
	            <th scope="col">Apellido</th>
	            <th scope="col">Email</th>
	        </tr>
	    </thead>
	    <tbody>
	    <%
	    for (Cliente c : listaClientes){
	    %>
	        <tr>
	            <th scope="row"><%= c.getIdCliente() %></th>
	            <td><%=c.getNombreCliente() %></td>
	            <td><%=c.getApellido() %></td>
	            <td><%=c.getEmail() %></td>
	            <td>
	            	<form>
	            		<button name="editar" class="btn btn-primary" value="<%= c.getIdCliente()%>" type="submit">Editar</button>
	            	</form>
	            </td>
	            <td>
	            	<form>
	            		<button name="borrar" class="btn btn-primary" value="<%= c.getIdCliente()%>" type="submit">Borrar</button>
	            	</form>
	            </td>
	            <td>
	            	<form>
	            		<button name="pedidos" class="btn btn-primary" value="<%= c.getIdCliente()%>" type="submit" >Lista de Pedidos</button>
	            	</form>
	            </td>
	        </tr>
	        <%
	    }
	        %>
	    </tbody>
	</table>
	<% 
	}catch(Exception e){
		
	}


%>
	

</body>
</html>