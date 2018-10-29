package negocio;

public class Empleado {
	private String nombre;
	private int legajo;
	private String direccion;
	private String cargo;
	private String mail;
	private String telefono;
	private float salario;
	
	
	public Empleado(String cargo, String nombre, String direccion, String mail, String telefono, float salario) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.salario = salario;
		this.cargo = cargo;
	}

	public String getCargo(){
		return this.cargo;
	}
	
	public void setCargo(String cargo){
	this.cargo = cargo;	
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
