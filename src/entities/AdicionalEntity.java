package entities;

import javax.persistence.*;

@Entity
@Table(name="Adicionales")
public class AdicionalEntity extends CuotaEntity {
	
	@ManyToOne
    @JoinColumn(name="legajo", nullable=false)
	private AlumnoEntity alumno;
	
	public AdicionalEntity(){
	}
			
		
 
}
