package com.cdt.productos.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdt.productos.backend.apirest.models.entity.Productos;
import com.cdt.productos.backend.apirest.models.services.ProductosServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductosRestController {
	
	@Autowired
	private ProductosServiceImpl productosService;
	
	@GetMapping("/productos")
	public List<Productos> index() {
		return productosService.productosNuevos();
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> showBuscar(@RequestBody Productos productos) {
		List<Productos> productoNuevo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productoNuevo = productosService.searchProduct(productos.getNombre_producto());
			System.out.println(productoNuevo);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(productos == null) {
			response.put("mensaje", "El producto ID: ".concat(productos.getEstado_producto().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return  ResponseEntity.ok(productoNuevo);
	}
	
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Optional<Productos> productos = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productos = productosService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(productos == null) {
			response.put("mensaje", "El producto ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(productos);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@RequestBody Productos productos, @PathVariable Long id) {
		Productos productoEncontrado = productosService.findById(id).get();
		
		Productos guardarProducto = null;
		Map<String, Object> response = new HashMap<>();
		guardarProducto = productoEncontrado;
		try {
			productoEncontrado.setTotal_producto(productos.getTotal_producto());
			this.productosService.save(productoEncontrado);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el producto");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Total de productos actualizado");
		response.put("pelicula", guardarProducto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/productos/page/{page}")
	public Page<Productos> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return productosService.nuevosProductos(pageable);
		
	}
	
	@PostMapping("/productos/page/{page}")
	public Page<Productos> indexPraginacion(@RequestBody Productos productos, @PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return productosService.productSearch(productos.getNombre_producto(), pageable);
		
	}

}
