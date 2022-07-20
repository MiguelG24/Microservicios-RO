package com.venta.service.entidades;

import java.io.Serializable;

import lombok.Data;

@Data
public class DetalleVentaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idDetalle;
	
	private Integer idVenta;
}
