package com.inventario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.dao.ArticuloDAO;
import com.inventario.service.dao.CategoriaArticuloDAO;
import com.inventario.service.entidades.CategoriaArticulo;

@Service
public class InventarioService {

	@Autowired
	private CategoriaArticuloDAO categoriaArticuloDAO;
	
	@Autowired
	private ArticuloDAO articuloDAO;
	
	//METODOS PARA CATEGORIA ARTICULOS
	
	//Listar categorias
	public List<CategoriaArticulo> getAllCategoriaArticulo(){
		return categoriaArticuloDAO.findAll();
	}
	
	//Buscar una categoria de articulo
	public CategoriaArticulo getCategoriaArticuloById(int idCategoriaUsuario) {
		return categoriaArticuloDAO.findById(idCategoriaUsuario).orElse(null);
	}
	
	//Insertar o Actualizar una categoria de articulos
	public CategoriaArticulo saveCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
		CategoriaArticulo nuevaCategoriaArticulo = categoriaArticuloDAO.save(categoriaArticulo);
		return nuevaCategoriaArticulo;
	}
	
	//Eliminar una categoria de articulo
	public void deleteCategoriaArticulo(int idCategoriaArticulo) {
		categoriaArticuloDAO.deleteById(idCategoriaArticulo);
	}
}
