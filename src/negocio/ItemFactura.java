package com.escuela.negocio;

public class ItemFactura {
	private int id;
	private String descripcion;
	private float costo;

	public ItemFactura(String descripcion, float costo) {
		this.descripcion = descripcion;
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	
}
