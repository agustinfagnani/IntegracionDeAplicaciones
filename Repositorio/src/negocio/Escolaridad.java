package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Escolaridad")
public class Escolaridad extends Cuota implements Serializable{


	public Escolaridad(){


	}

	public Escolaridad(String descr, float costo){
		super(descr,costo);

	}

}
