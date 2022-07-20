package com.usuario.service.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@Column(name = "nomUsuario", length = 20, nullable = false)
	private String nomUsuario;
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@Column(name = "apellidoPaterno", length = 20, nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno", length = 20, nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "password", length = 8, nullable = false)
	private String password;
	
    @JoinColumn(name = "idRol")
    @OneToOne(fetch = FetchType.LAZY)	
	private RolUsuario rolUsuario;
}
