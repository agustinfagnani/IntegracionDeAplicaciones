package negocio;

import javax.persistence.*;

@MappedSuperclass
public class TipoDePago {
	
	@Id
	@Column(name="id")
	private int id;
	
	public TipoDePago() {
		
	}
}
