package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.TitularSRV;
import negocio.Titular;




public class ListTitular 
{
	private List<Titular> titulares;
	
	public ListTitular()
	{
		titulares= new ArrayList<Titular>();
		titulares = TitularSRV.leerTitulares();
		}

	public List<Titular> getTitulares() {
		return titulares;
	}
	
	public void setTitulares(List<Titular> titu) {
		this.titulares = titu;
	}
	
	public void addTitular(Titular tit){
		titulares.add(tit);
		TitularSRV.grabarTitular(titulares);
	}
	
	public boolean removeTitular(Titular tit) {
		return titulares.remove(tit);
	}
	
	public Titular getTitularPorId(int id){
//		for(Titular u : titulares){
//			if(u.getDni()== id)
//				return u;
//		}
		return null;
	}
	
	
	
	
	public int size(){
		return titulares.size();
	}

	public void actualizarBD() 
	{
		TitularSRV.grabarTitular(titulares);
		
	}
}
