package com.cdt.productos.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "variaciones")
public class Variaciones implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_variacion;
	
	@Column
	private int producto_variacion;
	
	@Column
	private String color_variacion;

	public Long getId_variacion() {
		return id_variacion;
	}

	public void setId_variacion(Long id_variacion) {
		this.id_variacion = id_variacion;
	}

	public int getProducto_variacion() {
		return producto_variacion;
	}

	public void setProducto_variacion(int producto_variacion) {
		this.producto_variacion = producto_variacion;
	}

	public String getColor_variacion() {
		return color_variacion;
	}

	public void setColor_variacion(String color_variacion) {
		this.color_variacion = color_variacion;
	}
	
	

}
