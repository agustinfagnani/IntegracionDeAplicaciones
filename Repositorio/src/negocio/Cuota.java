package negocio;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public class Cuota implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="descripcion")
	protected String descripcion;
	
	@Column(name="costo")
	protected float costo;
	
	public Cuota(){
	}
	
	public Cuota(String descr, float costo){
		this.descripcion = descr;
		this.costo = costo;

	}
	public int getId() {
		return id;
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
