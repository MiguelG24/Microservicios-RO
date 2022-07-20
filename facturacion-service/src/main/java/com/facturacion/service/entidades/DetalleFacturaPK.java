package com.facturacion.service.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
//@Embeddable
public class DetalleFacturaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Column(name = "folioDetalle", nullable = false)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int folioDetalle;

	//@Column(name = "folioFactura", nullable = false, length = 36)
	private String folioFactura;
	
}
