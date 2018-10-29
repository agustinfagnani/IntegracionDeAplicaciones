package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Titulares")
public class Titular implements Serializable{
	
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
	
	public Titular(){
	}
	
	public Titular(String nombre, int DNI, String dire, String mail, String tel){
		this.nombre = nombre;
		this.DNI = DNI;
		this.direccion = dire;
		this.mail = mail;
		this.telefono = tel;
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
	
	
	
	
}
