package com.inventario.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventario.service.entidades.Articulo;

@Repository
public interface ArticuloDAO extends JpaRepository<Articulo, Integer>{

	
	Articulo findByDescripcion(String descripcion);
	
	List<Articulo> findByDescripcionLike(String descripcion);
	
	//@Query("select a from Articulo a where a.descripcion like :descripcion")
	
}
