package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Titulares")
public class Titular implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7095914413390747256L;

	@Column(name="nombre")
	private String nombre;
	
	@Id
	@Column(name="dni")
	private int DNI;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alumno> alumnos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private TipoDePago tipoDePago; 
	
	public Titular(){
	}
	
	public Titular(String nombre, int DNI, String dire, String mail, String tel, TipoDePago tipoDePago){
		this.nombre = nombre;
		this.DNI = DNI;
		this.direccion = dire;
		this.mail = mail;
		this.telefono = tel;
		this.alumnos = new ArrayList<Alumno>();
		this.tipoDePago = tipoDePago;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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
	
	public void addAlumno(Alumno a) {
		alumnos.add(a);
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public TipoDePago getTipoDePago() {
		return tipoDePago;
	}

	@Override
	public String toString(){
		return "DNI:"+this.DNI+" - "+this.nombre; 
	}
	
}
