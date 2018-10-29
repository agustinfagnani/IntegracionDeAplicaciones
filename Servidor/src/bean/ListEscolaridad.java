package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.EscolaridadSRV;
import negocio.Escolaridad;


public class ListEscolaridad 
{
	private List<Escolaridad> escolaridad;
	
	public ListEscolaridad()
	{
		escolaridad= new ArrayList<Escolaridad>();
		escolaridad =EscolaridadSRV.leerEscolaridad();
		}

	public List<Escolaridad> getEscolarida() {
		return escolaridad;
	}
	
	public void setEscolaridad(List<Escolaridad> escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	public void addEscolaridad(Escolaridad esc){
		escolaridad.add(esc);
		EscolaridadSRV.grabarEscolaridad(esc);
	}
	
	public boolean removeEscolaridad(Escolaridad esc) {
		return escolaridad.remove(esc);
	}
	
//	public Escolaridad getClientePorId(int id){
//		for(Escolaridad u : escolaridad){
//			if(u.getDni()== id)
//				return u;
//		}
//		return null;
//	}
//	
	
	
	
	public int size(){
		return escolaridad.size();
	}

	public void actualizarBD() 
	{
		//EscolaridadSRV.grabarEscolaridad(escolaridad);
		
	}
}
