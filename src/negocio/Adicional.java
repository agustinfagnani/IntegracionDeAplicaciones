package negocio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Adicionales")
public class Adicional extends Cuota implements Serializable {


	@ManyToOne 
    @JoinColumn(name="legajo", nullable=false)
	private Alumno alumno;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="costo")
	private float costo;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;



	public Adicional(){	


	}

	public Adicional(String descr, float costo){
		this.descripcion = descr;
		this.costo = costo;

	}	


}
