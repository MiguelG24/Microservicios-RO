package com.facturacion.service.controlador;

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

import com.facturacion.service.entidades.Factura;
import com.facturacion.service.servicio.FacturacionService;

@RestController
@RequestMapping("facturacion")
public class FacturacionController {

	@Autowired
	FacturacionService facturacionService;
	
	@GetMapping("listar")
	public ResponseEntity<List<Factura>> listarFacturas(){
		List<Factura> facturas = facturacionService.getAllFacturas();
		if (facturas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(facturas);
	}
	
	@GetMapping("buscar/{folio}")
	public ResponseEntity<Factura> buscarFactura(@PathVariable("folio") String folio){
		Factura factura = facturacionService.getFacturaById(folio);
		if (factura == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(factura);
	}
	
	@GetMapping("buscar-like/{folio}")
	public ResponseEntity<List<Factura>> buscarFacturaLike(@PathVariable("folio") String folio){
		List<Factura> facturas = facturacionService.getFacturaByIdLike(folio);
		if (facturas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(facturas);
	}
	
	@PostMapping("insertar")
	public ResponseEntity<Factura> guardarFactura(@RequestBody Factura factura){
		Factura nuevaFactura = facturacionService.saveFactura(factura);
		return ResponseEntity.ok(nuevaFactura);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<Factura> actualizarFactura(@RequestBody Factura facturaActualizada){
		Factura factura = facturacionService.getFacturaById(facturaActualizada.getFolio());
		if (factura == null) {
			return ResponseEntity.notFound().build();
		}
		facturacionService.saveFactura(facturaActualizada);
		return ResponseEntity.ok(facturaActualizada);
	}
	
	@DeleteMapping("delete/{folio}")
	public ResponseEntity<Void> eliminarFactura(@PathVariable("folio") String folio){
		facturacionService.deleteFactura(folio);
		return ResponseEntity.ok(null);
	}
}
