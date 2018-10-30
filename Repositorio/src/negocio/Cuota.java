package negocio;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public class Cuota implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="costo")
	private float costo;
	
	public Cuota(){
	}
	
	public Cuota(String descr, float costo){
		this.descripcion = descr;
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
