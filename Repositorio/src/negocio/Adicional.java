package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Adicionales")
public class Adicional extends Cuota implements Serializable {


	@ManyToOne 
    @JoinColumn(name="legajo", nullable=false)
	private Alumno alumno;

	public Adicional(){	


	}

	public Adicional(String descr, float costo){
		super(descr, costo);
	}	


}
