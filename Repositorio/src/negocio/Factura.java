package negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Facturas")
public class Factura implements Serializable{
	
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
	
	public Factura(int legajo, String tipo) {
		
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
