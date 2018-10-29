package negocio;

public class Cuota {
	private String descripcion;
	private float costo;
	
	public Cuota(String descripcion, float costo) {
		this.descripcion = descripcion;
		this.costo = costo;
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
