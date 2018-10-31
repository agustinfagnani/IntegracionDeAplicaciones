package negocio;

public class Credito extends TipoDePago {
	private String numero;
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
