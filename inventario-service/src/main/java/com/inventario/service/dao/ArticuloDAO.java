package com.inventario.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.service.entidades.Articulo;

@Repository
public interface ArticuloDAO extends JpaRepository<Articulo, Integer>{

}
