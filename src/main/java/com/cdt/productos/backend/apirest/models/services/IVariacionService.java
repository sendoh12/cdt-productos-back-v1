package com.cdt.productos.backend.apirest.models.services;

import java.util.List;

import com.cdt.productos.backend.apirest.models.entity.Variaciones;

public interface IVariacionService {
	public List<Variaciones> productosVariados(Integer estado);
}
