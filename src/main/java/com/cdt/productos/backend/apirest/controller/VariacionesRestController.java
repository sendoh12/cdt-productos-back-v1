package com.cdt.productos.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdt.productos.backend.apirest.models.entity.Variaciones;
import com.cdt.productos.backend.apirest.models.services.VariacionServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VariacionesRestController {
	
	@Autowired
	private VariacionServiceImpl variacionesService;
	
	@PostMapping("/variaciones")
	public ResponseEntity<?> showBuscar(@RequestBody Variaciones variaciones) {
		List<Variaciones> productosVariados = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productosVariados = variacionesService.productosNuevos(variaciones.getProducto_variacion());
			System.out.println(productosVariados);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(variaciones == null) {
			response.put("mensaje", "El producto variado ID: ".concat(variaciones.getId_variacion().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return  ResponseEntity.ok(productosVariados);
	}

}
