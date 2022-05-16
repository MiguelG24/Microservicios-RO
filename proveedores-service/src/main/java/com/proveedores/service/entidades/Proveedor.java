package com.proveedores.service.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {

	@Id
	@Column(name = "rfc", length = 13)
	private String rfc;
	
	@Column(name = "razonSocial", nullable = false, length = 50)
	private String razonSocial;
	
	@Column(name = "limiteCredito", nullable =  false)
	private float limiteCredito;
	
	@Column(name = "referenciaPago", nullable = false, length = 20)
	private String referenciaPago;
	
	@Column(name = "numeroCuenta", nullable = false, length = 14)
	private String numeroCuenta;
	
	@Column(name = "clabeInterbancaria", nullable = false, length = 18)
	private String clabeInterbancaria;
	
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;
	
	@Column(name = "direccion", nullable = false, length = 300)
	private String direccion;
}
