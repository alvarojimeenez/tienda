package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@Column(name = "ID_Cliente")
	private int idCliente;
	
	@Column(name = "Nombre")
	private String nombreCliente;
	
	@Column(name = "Apellido")
	private String apellido;

	@Column(name = "Email")
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listaPedidos;
	
	public Cliente() {
		super();
	}

	public Cliente(String nombreCliente, String apellido, String email) throws Exception {
		super();
		setNombreCliente(nombreCliente);
		setApellido(apellido);
		this.email = email;
	}

	public Cliente(int idCliente, String nombreCliente, String apellido, String email) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellido = apellido;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) throws Exception {
		if (nombreCliente.length()>50 || nombreCliente.isBlank() || nombreCliente==null) {
			throw new Exception("El nombre de cliente no es válido");
		}
		this.nombreCliente = nombreCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) throws Exception {
		if (apellido.length()>50 || apellido.isBlank() || apellido == null) {
			throw new Exception("El apellido no es válido");
		}else if (apellido.matches(".*\\d.*")) {
			throw new Exception("El apellido no puede contener numeros.");
		}
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && idCliente == other.idCliente;
	}
	
}
