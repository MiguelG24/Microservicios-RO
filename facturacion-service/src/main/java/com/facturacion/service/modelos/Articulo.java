package com.facturacion.service.modelos;

import lombok.Data;

@Data
public class Articulo {

	private int claveProducto;
	private String claveUnidadSAT;
	private String unidad;
	private String descripcion;
	private float valorUnitario;
	private float impuesto;
	private String categoria;
}
