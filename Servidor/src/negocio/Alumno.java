package negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Alumnos")
public class Alumno implements Serializable{

	@Column(name="nombre")
	private String nombre;

	@Id
	@Column(name="legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="dni")
	private Titular titular;

	@OneToOne 
	@JoinColumn(name="id")
	private Escolaridad escolaridad;

	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private List<Adicional> adicionales;

	@Column(name="direccion")
	private String direccion;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="telefono")
	private String telefono;
	
	public Alumno(){
	}
	public Alumno(String nombre, Titular titular, String dire, String mail, String tel, Escolaridad esc){
		this.nombre = nombre;
		this.titular = titular;
		this.direccion = dire;
		this.mail = mail;
		this.telefono = tel;
		this.escolaridad = esc;
		
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



}
