package negocio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="creditos")
public class Credito extends TipoDePago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -490698815644935247L;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="codSeg")
	private int codSeg;
	
	public Credito(String numero, int codSeg) {
		super();
		this.numero = numero;
	}
	
	public String getNumeroTarjeta() {
		return this.numero;
	}
	
	public int getCodSeg() {
		return this.codSeg;
	}
}
