package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Alumnos")
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4297026360803308613L;

	@Column(name="nombre")
	private String nombre;

	@Id
	@Column(name="legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;

	@OneToOne 
	@JoinColumn(name="id")
	private Escolaridad escolaridad;

	@ManyToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="alumno_adicional", joinColumns={@JoinColumn(name="legajo")}, inverseJoinColumns={@JoinColumn(name="id")})
	private List<Adicional> adicionales;

	@Column(name="direccion")
	private String direccion;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="telefono")
	private String telefono;
	
	public Alumno(){
	}
	public Alumno(String nombre, String dire, String mail, String tel, Escolaridad esc){
		this.nombre = nombre;
		this.direccion = dire;
		this.mail = mail;
		this.telefono = tel;
		this.escolaridad = esc;
		this.adicionales = new ArrayList<Adicional>();
		
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

	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	public void addAdicional(Adicional a) {
		adicionales.add(a);
	}


	@Override
	public String toString() {
		//return  nombre +"," + "legajo: "+legajo;
		return  "Legajo: "+legajo + " - " +nombre;
	}
	public boolean sosAlumn(int legajo) {
		
		return this.legajo == legajo;

	}
	public List<Adicional> getAdicionales() {
		return this.adicionales;
	}


}
