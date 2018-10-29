package entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Facturas")
public class FacturaEntity {
	
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
	
	@OneToMany(mappedBy = "factura")
	private List<ItemFacturaEntity> items;
	
	@OneToOne
	@JoinColumn(name="legajo")
	private AlumnoEntity alumno;
	
	public FacturaEntity(){
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
