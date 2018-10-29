package com.escuela.entities;

import javax.persistence.*;

@MappedSuperclass
public class CuotaEntity {
	
	//hay que poner ID??
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="costo")
	private float costo;
	
	public CuotaEntity(){
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
