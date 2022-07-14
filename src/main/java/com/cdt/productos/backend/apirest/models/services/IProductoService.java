package com.cdt.productos.backend.apirest.models.services;

import java.util.List;

import com.cdt.productos.backend.apirest.models.entity.Productos;

public interface IProductoService {
	public List<Productos> productosNuevos();
	public List<Productos> searchProduct(String estado);
	public Productos findById(Long id);
	public Productos save(Productos pelicula);

}
