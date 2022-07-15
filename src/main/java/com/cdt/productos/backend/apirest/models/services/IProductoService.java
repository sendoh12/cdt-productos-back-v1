package com.cdt.productos.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cdt.productos.backend.apirest.models.entity.Productos;

public interface IProductoService {
	public List<Productos> productosNuevos();
	public List<Productos> searchProduct(String estado);
	public Productos findById(Long id);
	public Productos save(Productos pelicula);
	
	public Page<Productos> findAllProdcutNew(Pageable pageable);
	public Page<Productos> findAllSearchProduct(String nombre, Pageable pageable);

}
