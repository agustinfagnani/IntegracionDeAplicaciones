package negocio;

import javax.persistence.*;

@MappedSuperclass
public class TipoDePago {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public TipoDePago() {
		
	}
}
