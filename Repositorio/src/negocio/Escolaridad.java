package negocio;

import java.io.Serializable;

import javax.persistence.*;

import org.omg.CORBA.SystemException;

@Entity
@Table(name="Escolaridad")
public class Escolaridad extends Cuota implements Serializable{

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="costo")
	private float costo;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	public Escolaridad(){


	}

	public Escolaridad(String descr, float costo){
		this.descripcion = descr;
		this.costo = costo;

	}
	
	public int getId() {
		return id;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public float getCosto() {
		return costo;
	}

	@Override
	public String toString(){
		return descripcion + " -Costo: " + costo;
	}

}
