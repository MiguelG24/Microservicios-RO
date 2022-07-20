package com.facturacion.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.service.dao.DetalleFacturaDAO;
import com.facturacion.service.dao.FacturaDAO;
import com.facturacion.service.entidades.Factura;

@Service
public class FacturacionService {

	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private DetalleFacturaDAO detalleFacturaDAO;
	
	//Listar facturas
	public List<Factura> getAllFacturas(){
		return facturaDAO.findAll();
	}
	
	//Buscar factura
	public Factura getFacturaById(String folio) {
		return facturaDAO.findById(folio).orElse(null);
	}
	
	//Buscar factura - funcion Like
	public List<Factura> getFacturaByIdLike(String folio){
		return facturaDAO.findByFolioLike("%" + folio + "%");
	}
	
	//Guardar una factura
	public Factura saveFactura(Factura factura) {
		Factura nuevaFactura = facturaDAO.save(factura);
		return nuevaFactura;
	}
	
	//Eliminar una factura 
	public void deleteFactura(String folio) {
		facturaDAO.deleteById(folio);
	}
}
