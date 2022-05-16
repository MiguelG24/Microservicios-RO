package com.proveedores.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proveedores.service.entidades.Proveedor;
import com.proveedores.service.servicio.ProveedorService;

@RestController
@RequestMapping("proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	//Listar Proveedores
	@GetMapping("listar")
	public ResponseEntity<List<Proveedor>> listar(){
		List<Proveedor> proveedores = proveedorService.getAll();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}		
		return ResponseEntity.ok(proveedores);
	}
	
	//Buscar Proveedor por RFC
	@GetMapping("buscar/rfc/{rfc}")
	public ResponseEntity<Proveedor> buscarProveedorPorRfc(@PathVariable("rfc") String rfc){
		Proveedor proveedor = proveedorService.getProveedorByRfc(rfc);
		if (proveedor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedor);
	}
	
	//Buscar Proveedores por RFC - funcion Like
	@GetMapping("buscar/rfc-like/{rfc}")
	public ResponseEntity<List<Proveedor>> buscarProveedorPorRfcLike(@PathVariable("rfc") String rfc){
		List<Proveedor> proveedores = proveedorService.getProveedoresByRfcLike(rfc);
		if (proveedores.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedores);
	}
	
	//Buscar Proveedor por razon social
	@GetMapping("buscar/razonSocial/{razonSocial}")
	public ResponseEntity<Proveedor> buscarProveedorPorRazonSocial(@PathVariable("razonSocial") String razonSocial){
		Proveedor proveedor = proveedorService.getProveedorByRazonSocial(razonSocial);
		if (proveedor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedor);
	}
	
	//Buscar Proveedores por razon social - funcion Like
	@GetMapping("buscar/razonSocial-like/{razonSocial}")
	public ResponseEntity<List<Proveedor>> buscarProveedorPorRazonSocialLike(@PathVariable("razonSocial") String razonSocial){
		List<Proveedor> proveedores = proveedorService.getProveedorByRazonSocialLike(razonSocial);
		if (proveedores.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedores);
	}
	
	//Insertar un Proveedor
	@PostMapping("insertar")
	public ResponseEntity<Proveedor> guardarProveedor(@RequestBody Proveedor proveedor){
		Proveedor nuevoProveedor = proveedorService.saveProveedor(proveedor);
		return ResponseEntity.ok(nuevoProveedor);
	}
	
	//Actualizar un Proveedor
	@PutMapping("actualizar")
	public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor proveedor){
		Proveedor proveedorMod = proveedorService.getProveedorByRfc(proveedor.getRfc());
		if (proveedorMod ==  null) {
			return ResponseEntity.notFound().build();
		}
		proveedorService.saveProveedor(proveedor);
		return ResponseEntity.ok(proveedor);
	}
	
	//Eliminar un Proveedor
	@DeleteMapping("eliminar/{rfc}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable("rfc") String rfc){
		proveedorService.deleteProveedor(rfc);
		return ResponseEntity.ok(null);
	}
}
