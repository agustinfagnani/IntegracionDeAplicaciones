package negocio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Deposito")
public class Deposito extends TipoDePago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6891052065780954775L;
	
	@Column(name="cbu")
	private String cbu; //22 Digitos
	
	public Deposito(String cbu) {
		super();
		this.cbu = cbu;
	}
	
	public String getCBU() {
		return this.cbu;
	}
}
