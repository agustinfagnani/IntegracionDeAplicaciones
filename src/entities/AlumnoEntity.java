package com.escuela.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="alumnos")
public class AlumnoEntity {
	
	@Column(name="nombre")
	private String nombre;
	
	@Id
	@Column(name="legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;
	
	@OneToOne
	@Column(name="titular")
	private TitularEntity titular;
	
	@OneToOne
	@Column(name="escolaridad")
	private EscolaridadEntity escolaridad;
	
	@OneToMany
	@Column(name="adicionales")
	private List<AdicionalEntity> adicionales;
	
	public AlumnoEntity(){
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public TitularEntity getTitular() {
		return titular;
	}

	public void setTitular(TitularEntity titular) {
		this.titular = titular;
	}

	public EscolaridadEntity getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(EscolaridadEntity escolaridad) {
		this.escolaridad = escolaridad;
	}

	public List<AdicionalEntity> getAdicionales() {
		return adicionales;
	}

	public void setAdicionales(List<AdicionalEntity> adicionales) {
		this.adicionales = adicionales;
	}
	
	
	
}
