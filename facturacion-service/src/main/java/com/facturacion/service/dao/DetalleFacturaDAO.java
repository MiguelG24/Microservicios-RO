package com.facturacion.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.service.entidades.DetalleFactura;
import com.facturacion.service.entidades.DetalleFacturaPK;

@Repository
public interface DetalleFacturaDAO extends JpaRepository<DetalleFactura, DetalleFacturaPK>{

}
