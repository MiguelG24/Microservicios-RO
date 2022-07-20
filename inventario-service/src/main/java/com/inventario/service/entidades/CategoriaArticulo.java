package com.inventario.service.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CategoriaArticulo")
public class CategoriaArticulo {

	@Id
	@Column(name = "idCategoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;
	
//	@OneToOne(mappedBy = "categoriaArticulo", cascade = CascadeType.ALL, 
//			fetch = FetchType.LAZY, optional = false)
//	private Articulo articulo;
}
