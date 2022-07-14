package com.cdt.productos.backend.apirest.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Productos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	
	@Column
	private String nombre_producto;
	
	@Column
	private String imagen_producto;
	
	@Column
	private String descripcion_producto;
	
	@Column
	private int total_producto;
	
	@Column
	private int precio_producto;
	
	@Column
    private int variacion_producto;
	
	@Column
    private String estado_producto;
	
	@Column
    private String blanco_producto;
	
	@Column
    private String negro_producto;
	
	@Column
    private String azul_producto;
	
	@Column
    private String gris_producto;

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getImagen_producto() {
		return imagen_producto;
	}

	public void setImagen_producto(String imagen_producto) {
		this.imagen_producto = imagen_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public int getTotal_producto() {
		return total_producto;
	}

	public void setTotal_producto(int total_producto) {
		this.total_producto = total_producto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public int getVariacion_producto() {
		return variacion_producto;
	}

	public void setVariacion_producto(int variacion_producto) {
		this.variacion_producto = variacion_producto;
	}

	public String getEstado_producto() {
		return estado_producto;
	}

	public void setEstado_producto(String estado_producto) {
		this.estado_producto = estado_producto;
	}

	public String getBlanco_producto() {
		return blanco_producto;
	}

	public void setBlanco_producto(String blanco_producto) {
		this.blanco_producto = blanco_producto;
	}

	public String getNegro_producto() {
		return negro_producto;
	}

	public void setNegro_producto(String negro_producto) {
		this.negro_producto = negro_producto;
	}

	public String getAzul_producto() {
		return azul_producto;
	}

	public void setAzul_producto(String azul_producto) {
		this.azul_producto = azul_producto;
	}

	public String getGris_producto() {
		return gris_producto;
	}

	public void setGris_producto(String gris_producto) {
		this.gris_producto = gris_producto;
	}
	
}
