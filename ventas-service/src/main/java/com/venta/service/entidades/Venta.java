package com.venta.service.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Venta")
public class Venta {

	@Id
	@Column(name = "idVenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	
	@Column(name = "fecha")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(name = "hora")
	private LocalTime hora;
	
	@Column(name = "nomUsuario")
	private Integer nomUsuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta", fetch = FetchType.LAZY)
	private List<DetalleVenta> detalleVentas;
}
