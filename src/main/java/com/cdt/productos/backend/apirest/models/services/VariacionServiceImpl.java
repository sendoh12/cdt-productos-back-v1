package com.cdt.productos.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdt.productos.backend.apirest.models.dao.IVariacionesDao;
import com.cdt.productos.backend.apirest.models.entity.Variaciones;

@Service
public class VariacionServiceImpl {
	
	@Autowired
	private IVariacionesDao variacionesDao;
	
	@Transactional(readOnly = true)
	public List<Variaciones> productosNuevos(Integer estado) {
		return variacionesDao.productosNuevos(estado);
		
	}

}
