package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.AdicionalSRV;
import negocio.Adicional;


public class ListAdicional 
{
	private List<Adicional> adicionales;
	
	public ListAdicional()
	{
		adicionales= new ArrayList<Adicional>();
		adicionales = AdicionalSRV.leerAdicionales();
		}

	public List<Adicional> getAlumnos() {
		return adicionales;
	}
	
	public void setAdicional(List<Adicional> adic) {
		this.adicionales = adic;
	}
	
	public void addAdicional(Adicional adic){
		adicionales.add(adic);
		AdicionalSRV.grabarAdicional(adic);
	}
	
	public boolean removeAdicional(Adicional adic) {
		return adicionales.remove(adic);
	}
	
	public Adicional getAdicionalPorId(int id){
//		for(Adicional u : adicionales){
//			if(u.getDni()== id)
//				return u;
//		}
		return null;
	}
	
	
	
	
	public int size(){
		return adicionales.size();
	}

	public void actualizarBD() 
	{
		AdicionalSRV.grabarAdicionales(adicionales);
		
	}
}
