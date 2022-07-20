package com.facturacion.service.entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@Column(name = "folio", length = 36, nullable = false)
	private String folio;
	
	@Column(name = "rfcProveedor", length = 13, nullable = false)
	private String rfcProveedor;
	
	@Column(name = "fechaEmitida", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEmitida;
	
	@Column(name = "fechaRecibida", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaRecibida;
	
	@Column(name = "diasRestantes", nullable = false)
	private Integer diasRestantes;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "folioFactura", fetch = FetchType.LAZY)
	private List<DetalleFactura> detalleFacturas;
}
