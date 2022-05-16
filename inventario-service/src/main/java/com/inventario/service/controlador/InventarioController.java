package com.inventario.service.controlador;

import java.util.List;
import java.util.Map;

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

import com.inventario.service.entidades.Articulo;
import com.inventario.service.entidades.CategoriaArticulo;
import com.inventario.service.servicio.InventarioService;

@RestController
@RequestMapping("inventario")
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;
	
	//SERVICIOS CATEGORIA ARTICULOS
	
	//Listar categorias
	@GetMapping("categoriaArticulo/listar")
	public ResponseEntity<List<CategoriaArticulo>> listarCategoriasArticulos(){
		List<CategoriaArticulo> categoriasArticulos = inventarioService.getAllCategoriaArticulo();
		if (categoriasArticulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categoriasArticulos);
	}
	
	//Buscar una categoria
	@GetMapping("categoriaArticulo/buscarPorId/{idCategoria}")
	public ResponseEntity<CategoriaArticulo> buscarCategoriaArticulo(@PathVariable("idCategoria") int idCategoria){
		CategoriaArticulo categoriaArticulo = inventarioService.getCategoriaArticuloById(idCategoria);
		if (categoriaArticulo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoriaArticulo);
	}
	
	//Insertar una categoria
	@PostMapping("categoriaArticulo/insertar")
	public ResponseEntity<CategoriaArticulo> guardarCategoriaArticulo(@RequestBody CategoriaArticulo categoriaArticulo){
		CategoriaArticulo nuevCategoriaArticulo = inventarioService.saveCategoriaArticulo(categoriaArticulo);
		return ResponseEntity.ok(nuevCategoriaArticulo);
	}
	
	//Actualizar una categoria
	@PutMapping("categoriaArticulo/actualizar")
	public ResponseEntity<CategoriaArticulo> actualizarCategoriaArticulo(@RequestBody CategoriaArticulo categoriaArticulo){
		CategoriaArticulo categoriaActualizada = inventarioService.getCategoriaArticuloById(categoriaArticulo.getIdCategoria());
		if (categoriaActualizada == null) {
			return ResponseEntity.notFound().build();
		}
		inventarioService.saveCategoriaArticulo(categoriaArticulo);
		return ResponseEntity.ok(categoriaArticulo);
	}
	
	//Eliminar una categoria
	@DeleteMapping("categoriaArticulo/eliminar/{idCategoriaArticulo}")
	public ResponseEntity<Void> eliminarCategoriaArticulo(@PathVariable("idCategoriaArticulo") int idCategoriaArticulo){
		inventarioService.deleteArticulo(idCategoriaArticulo);
		return ResponseEntity.ok(null);
	}
	
	//SERVICIOS ARTICULOS
	
	//Listar articulos
	@GetMapping("articulos/listar")
	public ResponseEntity<List<Map<String, String>>> listarArticulos(){
		List<Map<String, String>> articulos = inventarioService.getAllMapArticulo();
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(articulos);
	}
	
	//Buscar articulo por clave de producto
	@GetMapping("articulos/buscar/claveProducto/{claveProducto}")
	public ResponseEntity<Map<String, String>> buscarArticuloPorClave(@PathVariable("claveProducto") int claveProducto){
		Map<String, String> articulo = inventarioService.getMapArticuloById(claveProducto);
		if (articulo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(articulo);
	}
	
	//Buscar articulo por descripcion
	@GetMapping("articulos/buscar/descripcion/{descripcion}")
	public ResponseEntity<Map<String, String>> buscarArticuloPorDescripcion(@PathVariable("descripcion") String descripcion){
		Map<String, String> articulo = inventarioService.getMapArticuloByDescripcion(descripcion);
		if (articulo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(articulo);
	}
	
	//Buscar articulos por descripcion - funcion LIKE
	@GetMapping("articulos/buscar/descripcion-like/{descripcion}")
	public ResponseEntity<List<Map<String, String>>> buscarArticuloPorDescripcionLike(@PathVariable("descripcion") String descripcion){
		List<Map<String, String>> articulos = inventarioService.getMapArticulosByDescripcionLike(descripcion);
		if (articulos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(articulos);
	}
	
	//Insertar un articulo
	@PostMapping("articulos/insertar")
	public ResponseEntity<Articulo> guardarArticulo(@RequestBody Articulo articulo){
		Articulo nuevoArticulo = inventarioService.saveArticulo(articulo);
		return ResponseEntity.ok(nuevoArticulo);
	}
	
	//Actualizar un articulo
	@PutMapping("articulos/actualizar")
	public ResponseEntity<Articulo> actualizarArticulo(@RequestBody Articulo articulo){
		Articulo articuloActualizado = inventarioService.getArticuloById(articulo.getClaveProducto());
		if (articuloActualizado == null) {
			return ResponseEntity.notFound().build();
		}
		inventarioService.saveArticulo(articulo);
		return ResponseEntity.ok(articulo);
	}
	
	//Eliminar articulo
	@DeleteMapping("articulos/eliminar/{claveProducto}")
	public ResponseEntity<Void> eliminarArticulo(@PathVariable("claveProducto") int claveProducto){
		inventarioService.deleteArticulo(claveProducto);
		return ResponseEntity.ok(null);
	}
}
