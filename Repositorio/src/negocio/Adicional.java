package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Adicionales")
public class Adicional extends Cuota implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 2329727390610009023L;

	/*
	@ManyToOne 
    @JoinColumn(name="legajo", nullable=false)
	private Alumno alumno;
*/
	public Adicional(){	


	}

	public Adicional(String descr, float costo){
		super(descr, costo);
	}	

	@Override
	public String toString() {
		return  super.getDescripcion();
	}

}
