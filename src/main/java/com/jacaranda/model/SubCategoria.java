package com.jacaranda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SubCategoria")
public class SubCategoria {
	
	
	@Id
	@Column(name = "ID_SubCategoria")
	private int idSubCategoria;
	
	@Column(name = "NombreSubCategoria")
	private String nombreSubCategoria;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_Producto", referencedColumnName = "ID_Producto"), 
		@JoinColumn(name = "ID_Categoria", referencedColumnName = "ID_Categoria")
	})
	private ProductoCategoria productoCategoria;
	
	
}
