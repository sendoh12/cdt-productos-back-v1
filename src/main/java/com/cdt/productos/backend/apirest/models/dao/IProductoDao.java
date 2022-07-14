package com.cdt.productos.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdt.productos.backend.apirest.models.entity.Productos;

public interface IProductoDao extends JpaRepository<Productos, Long> {
	
	@Query(value ="select * from productos p where p.estado_producto = 'nuevo'", nativeQuery = true)
	public List<Productos> productosNuevos();
	
	@Query(value ="select * from productos p where UPPER(p.nombre_producto) like %:nombre%", nativeQuery = true)
	public List<Productos> searchProduct(@Param(value = "nombre") String nombre);

}
