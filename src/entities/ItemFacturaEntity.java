package entities;

import javax.persistence.*;

@Entity
@Table(name="ItemsFactura")
public class ItemFacturaEntity {
	
	@ManyToOne
    @JoinColumn(name="numero", nullable=false)
	private FacturaEntity factura;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="costo")
	private float costo;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public ItemFacturaEntity(){
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
