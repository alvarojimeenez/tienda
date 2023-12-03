package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Id
	@Column(name = "ID_Categoria")
	private int idCategoria;
	
	@Column(name = "NombreCategoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy = "categoria")
	private List<ProductoCategoria> listaProductoCategoria;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<ProductoCategoria> getListaProductoCategoria() {
		return listaProductoCategoria;
	}

	public void setListaProductoCategoria(List<ProductoCategoria> listaProductoCategoria) {
		this.listaProductoCategoria = listaProductoCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return idCategoria == other.idCategoria;
	}
	
	
}
