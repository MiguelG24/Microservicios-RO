package com.proveedores.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proveedores.service.entidades.Proveedor;

@Repository
public interface ProveedorDAO extends JpaRepository<Proveedor, String>{

	Proveedor findByRazonSocial(String razonSocial);
	
	List<Proveedor> findByRfcLike(String rfc);
	
	List<Proveedor> findByRazonSocialLike(String razonSocial);
}
