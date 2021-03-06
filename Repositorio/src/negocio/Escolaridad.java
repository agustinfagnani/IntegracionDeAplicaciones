package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Escolaridad")
public class Escolaridad extends Cuota implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -851612430252726916L;

	public Escolaridad(){


	}

	public Escolaridad(String descr, float costo){
		super(descr,costo);

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
