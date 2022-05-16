package com.proveedores.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proveedores.service.dao.ProveedorDAO;
import com.proveedores.service.entidades.Proveedor;

@Service
public class ProveedorService {

	@Autowired
	private ProveedorDAO proveedorDAO;

	//Listar Proveedores
	public List<Proveedor> getAll(){
		return proveedorDAO.findAll();
	}
	
	//Buscar Proveedor por RFC
	public Proveedor getProveedorByRfc(String rfc) {
		return proveedorDAO.findById(rfc).orElse(null);
	}
	
	//Buscar Proveedores por RFC - funcion Like
	public List<Proveedor> getProveedoresByRfcLike(String rfc){
		return proveedorDAO.findByRfcLike("%" + rfc + "%");
	}
	
	//Buscar Proveedor por razon social
	public Proveedor getProveedorByRazonSocial(String razonSocial) {
		return proveedorDAO.findByRazonSocial(razonSocial);
	}
	
	//Buscar Proveedores por razon social - funcion Like
	public List<Proveedor> getProveedorByRazonSocialLike(String razonSocial){
		return proveedorDAO.findByRazonSocialLike("%" + razonSocial + "%");
	}
	
	//Insertar o Actualizar un Proveedor
	public Proveedor saveProveedor(Proveedor proveedor) {
		Proveedor nuevoProveedor = proveedorDAO.save(proveedor);
		return nuevoProveedor;
	}
	
	//Eliminar un Proveedor
	public void deleteProveedor(String rfc) {
		proveedorDAO.deleteById(rfc);
	}
}
