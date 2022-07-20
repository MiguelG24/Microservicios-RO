package com.facturacion.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.service.entidades.Factura;

@Repository
public interface FacturaDAO extends JpaRepository<Factura, String>{

	List<Factura> findByFolioLike(String folio);
}
