package com.cdt.productos.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdt.productos.backend.apirest.models.dao.IProductoDao;
import com.cdt.productos.backend.apirest.models.entity.Productos;

@Service
public class ProductosServiceImpl {
	
	@Autowired
	private IProductoDao productosDao;
	
	@Transactional(readOnly = true)
	public List<Productos> productosNuevos() {
		return productosDao.productosNuevos();
		
	}
	
	@Transactional(readOnly = true)
	public List<Productos> searchProduct(String estado) {
		return productosDao.searchProduct(estado);
		
	}
	
	@Transactional(readOnly = true)
	public Optional<Productos> findById(Long id) {
		return productosDao.findById(id);
	}
	
	public Productos save(Productos productos) {
		return productosDao.save(productos);
	}

}
