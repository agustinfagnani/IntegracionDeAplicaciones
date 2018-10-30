package negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Facturas")
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4896935246852940699L;

	@Id
	@Column(name="numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="fechaEmision")
	private LocalDateTime fechaEmision;
	
	@Column(name="fechaPago")
	private LocalDateTime fechaPago;
	
	@OneToMany (cascade=CascadeType.ALL)
	private List<ItemFactura> items;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="legajo")
	private Alumno alumno;
	
	public Factura(){
	}
	
	public Factura(Alumno a, String tipo) {
		this.tipo = tipo;
		this.fechaEmision = LocalDateTime.now();
		this.items = new ArrayList<ItemFactura>();
		
		this.items.add(new ItemFactura(this, a.getEscolaridad().getDescripcion(), a.getEscolaridad().getCosto()));
	
		for(Adicional ad: a.getAdicionales()) {
			this.items.add(new ItemFactura(this, ad.getDescripcion(), ad.getCosto()));
		}
		
		this.fechaPago = null;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	
	public boolean isPago() {
		if(this.fechaPago == null)
			return false;
		return true;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public LocalDateTime getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
}
