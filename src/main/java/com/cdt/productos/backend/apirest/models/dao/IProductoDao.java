package com.cdt.productos.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdt.productos.backend.apirest.models.entity.Productos;

public interface IProductoDao extends JpaRepository<Productos, Long> {
	
	@Query(value ="select * from productos p where p.estado_producto = 'nuevo'", nativeQuery = true)
	public List<Productos> productosNuevos();
	
	@Query(value ="select * from productos p where UPPER(p.nombre_producto) like %:nombre%", nativeQuery = true)
	public List<Productos> searchProduct(@Param(value = "nombre") String nombre);
	
	@Query(value ="select * from productos where productos.estado_producto = 'nuevo'", nativeQuery = true)
	public Page<Productos> nuevosProductos(Pageable pageable);
	
	@Query(value ="select * from productos where UPPER(productos.nombre_producto) like %:nombre%", nativeQuery = true)
	public Page<Productos> productSearch(@Param(value = "nombre") String nombre, Pageable pageable);

}
