package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {
	
	@Id
	@Column(name = "ID_Producto")
	private int idProducto;
	
	@Column(name = "NombreProducto")
	private String nombreProducto;
	
	@Column(name = "Precio")
	private double precio;
	
	@OneToMany(mappedBy = "producto")
	private List<DetallePedido> listaDetallesPedido;
	
	@OneToMany(mappedBy = "producto")
	private List<ProductoCategoria> listaProductoCategoria;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}
	
	
}
