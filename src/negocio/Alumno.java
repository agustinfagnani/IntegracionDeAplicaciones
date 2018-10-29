package negocio;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private int legajo;
	private Titular titular;
	private String direccion;
	private String mail;
	private String telefono;
	private Escolaridad escolaridad;
	private List<Adicional> adicionales;
	
	
	

	public Alumno(String nombre, Titular titular, String direccion, String mail, String telefono,
			Escolaridad escolaridad) {
		this.nombre = nombre;
		this.titular = titular;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.escolaridad = escolaridad;
		this.adicionales = new ArrayList<Adicional>();
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}

	public List<Adicional> getAdicionales() {
		return adicionales;
	}

	public void setAdicionales(List<Adicional> adicionales) {
		this.adicionales = adicionales;
	}

	public void addCuota(Cuota c) {
		this.adicionales.add((Adicional)c);
		
	}
	
	
	
}
