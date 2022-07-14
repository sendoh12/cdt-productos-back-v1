package com.cdt.productos.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cdt.productos.backend.apirest.models.entity.Variaciones;

public interface IVariacionesDao extends JpaRepository<Variaciones, Long>{
	
	@Query(value ="select * from variaciones v where v.producto_variacion = :estado", nativeQuery = true)
	public List<Variaciones> productosNuevos(@Param(value = "estado") Integer estado);

}
