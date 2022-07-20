package com.facturacion.service.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DetalleFactura")
@IdClass(DetalleFacturaPK.class)
public class DetalleFactura implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	//private DetalleFacturaPK detalleFacturaPK;
	
	@Id
	@Column(name = "folioDetalle")
	@GeneratedValue
	private int folioDetalle;
	
	@Id
	@Column(name = "folioFactura", length = 36)
	private String folioFactura;
	
	@Column(name = "claveProducto", nullable = false)
	private Integer claveProducto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "precio", nullable = false)
	private Float precio;
	
	@Column(name = "impuestoTrasladado", nullable = false)
	private Float impuestoTrasladado;
	
}
