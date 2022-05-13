package com.inventario.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.service.entidades.CategoriaArticulo;

@Repository
public interface CategoriaArticuloDAO extends JpaRepository<CategoriaArticulo, Integer>{

}
