package com.jacaranda.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DetallePedido")
public class DetallePedido {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_Pedido")
	private Pedido pedido;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	private Producto producto;
	
	@Id
	@Column(name = "Cantidad")
	private int cantidad;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePedido other = (DetallePedido) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(producto, other.producto);
	}
	
	
}
