package com.inventario.service.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Articulo")
public class Articulo {

	@Id
	@Column(name = "claveProducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claveProducto;
	
	@Column(name = "claveUnidadSAT", nullable = false, length = 30)
	private String claveUnidadSAT;
	
	@Column(name = "unidad", nullable = false, length = 20)
	private String unidad;
	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "valorUnitario", nullable = false)
	private float valorUnitario;
	
	@Column(name = "impuesto", nullable = false)
	private float impuesto;
	
	@Column(name = "idCategoria", nullable = false)
	private int idCategoria;
	
}
