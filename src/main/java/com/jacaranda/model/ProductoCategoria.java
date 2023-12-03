package com.jacaranda.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductoCategoria")
public class ProductoCategoria {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_Categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "productoCategoria")
	private List<SubCategoria> listaSubCategorias;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
