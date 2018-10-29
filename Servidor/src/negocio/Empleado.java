package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Empleados")
public class Empleado implements Serializable{

	@Column(name="DNI")
	private int  DNI;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="cargo")
	private String cargo;
	
	@Id
	@Column(name="legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;


	@Column(name="direccion")
	private String direccion;

	@Column(name="mail")
	private String mail;

	@Column(name="telefono")
	private String telefono;

	@Column(name="salario")
	private float salario;

	public Empleado(){

	}
	public Empleado(int DNI, String cargo, String nombre, String dire, String mail, String tel, float salario){
		this.DNI=DNI;
		this.cargo = cargo;
		this.nombre = nombre;
		this.direccion=dire;
		this.mail = mail;
		this.telefono = tel;
		this.salario = salario;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}




}