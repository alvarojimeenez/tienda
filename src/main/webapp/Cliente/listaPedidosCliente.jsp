<%@page import="com.jacaranda.model.Pedido"%>
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
	String idCadena = (String) session.getAttribute("idCliente");
	int idCliente = Integer.valueOf(idCadena);
	
	try{
		cliente = DbRepository.findInt(Cliente.class, idCliente);
	}catch(Exception e){
		
	}
	%>
	
	<table class="table">
	    <thead>
	        <tr>
	            <th scope="col">Id Pedido</th>
	            <th scope="col">Cliente</th>
	            <th scope="col">Fecha pedido</th>
	        </tr>
	    </thead>
	    <tbody>
	    <%
	    if (cliente!=null){
	    for (Pedido p : cliente.getListaPedidos()){
	    %>
	        <tr>
	            <th scope="row"><%= p.getIdPedido() %></th>
	            <td> <%= p.getCliente().getNombreCliente() %>
	            <td><%=p.getFechaPedido() %></td>

	         
	        </tr>
	        <%
	    }}
	        %>
	    </tbody>
	</table>
</body>
</html>