package com.inventario.service.servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.dao.ArticuloDAO;
import com.inventario.service.dao.CategoriaArticuloDAO;
import com.inventario.service.entidades.Articulo;
import com.inventario.service.entidades.CategoriaArticulo;

@Service
public class InventarioService {

	@Autowired
	private CategoriaArticuloDAO categoriaArticuloDAO;

	@Autowired
	private ArticuloDAO articuloDAO;

	// METODOS PARA CATEGORIA ARTICULOS

	// Listar categorias
	public List<CategoriaArticulo> getAllCategoriaArticulo() {
		return categoriaArticuloDAO.findAll();
	}

	// Buscar una categoria de articulo
	public CategoriaArticulo getCategoriaArticuloById(int idCategoriaUsuario) {
		return categoriaArticuloDAO.findById(idCategoriaUsuario).orElse(null);
	}

	// Insertar o Actualizar una categoria de articulos
	public CategoriaArticulo saveCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
		CategoriaArticulo nuevaCategoriaArticulo = categoriaArticuloDAO.save(categoriaArticulo);
		return nuevaCategoriaArticulo;
	}

	// Eliminar una categoria de articulo
	public void deleteCategoriaArticulo(int idCategoriaArticulo) {
		categoriaArticuloDAO.deleteById(idCategoriaArticulo);
	}

	// METODOS PARA ARTICULO

	// Listar articulos
	public List<Articulo> getAllArticulo() {
		return articuloDAO.findAll();
	}

	public List<Map<String, String>> getAllMapArticulo() {

		List<Articulo> articulos = articuloDAO.findAll();

		List<Map<String, String>> listMapArticulos = new ArrayList<>();

		for (Articulo artModificar : articulos) {
			listMapArticulos.add(getMapArticulo(artModificar));
		}

		return listMapArticulos;
	}

	// Buscar articulo con idCategoria
	public Articulo getArticuloById(int claveProducto) {
		return articuloDAO.findById(claveProducto).orElse(null);
	}

	// Buscar articulo con nombre de categoria
	public Map<String, String> getMapArticulo(Articulo artModificar) {

		CategoriaArticulo categoria = getCategoriaArticuloById(artModificar.getIdCategoria());

		Map<String, String> articulo = new HashMap<String, String>();

		articulo.put("claveProducto", String.valueOf(artModificar.getClaveProducto()));
		articulo.put("claveUnidadSAT", artModificar.getClaveUnidadSAT());
		articulo.put("unidad", artModificar.getUnidad());
		articulo.put("descripcion", artModificar.getDescripcion());
		articulo.put("valorUnitario", String.valueOf(artModificar.getValorUnitario()));
		articulo.put("impuesto", String.valueOf(artModificar.getImpuesto()));
		articulo.put("nombreCategoria", categoria.getNombre());

		return articulo;
	}

	// Buscar un articulo por clave
	public Map<String, String> getMapArticuloById(int claveProducto) {

		Articulo artModificar = articuloDAO.findById(claveProducto).orElse(null);

		if (artModificar == null) {
			return null;
		}

		return getMapArticulo(artModificar);
	}

	// Buscar un articulo por descripcion
	public Articulo getArticuloByDescripcion(String nombre) {
		return articuloDAO.findByDescripcion(nombre);
	}

	public Map<String, String> getMapArticuloByDescripcion(String nombre) {
		Articulo artModificar = articuloDAO.findByDescripcion(nombre);

		if (artModificar == null) {
			return null;
		}

		return getMapArticulo(artModificar);
	}

	// Buscar articulo por descripcion - funcion Like
	public List<Articulo> getArticulosByDescripcionLike(String descripcion) {
		return articuloDAO.findByDescripcionLike("%" + descripcion + "%");
	}

	public List<Map<String, String>> getMapArticulosByDescripcionLike(String descripcion) {
		
		List<Articulo> articulos = articuloDAO.findByDescripcionLike("%" + descripcion + "%");

		List<Map<String, String>> listMapArticulos = new ArrayList<>();

		for (Articulo artModificar : articulos) {
			listMapArticulos.add(getMapArticulo(artModificar));
		}

		return listMapArticulos;
	}

	// Insertar o Actualizar un articulo
	public Articulo saveArticulo(Articulo articulo) {
		Articulo nuevoArticulo = articuloDAO.save(articulo);
		return nuevoArticulo;
	}

	// Eliminar un articulo
	public void deleteArticulo(int claveProducto) {
		articuloDAO.deleteById(claveProducto);
	}
}
