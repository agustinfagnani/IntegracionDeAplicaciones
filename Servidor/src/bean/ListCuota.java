package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.CuotaSRV;
import negocio.Cuota;




public class ListCuota 
{
	private List<Cuota> cuotas;
	
	public ListCuota()
	{
		cuotas= new ArrayList<Cuota>();
		cuotas = CuotaSRV.leerCuotas();
		}

	public List<Cuota> getCuotas() {
		return cuotas;
	}
	
	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	public void addCuota(Cuota cuota){
		cuotas.add(cuota);
		CuotaSRV.grabarCuota(cuota);
	}
	
	public boolean removeAlumno(Cuota cuota) {
		return cuotas.remove(cuota);
	}
	
	public Cuota getCuotasPorId(int id){
		for(Cuota u : cuotas){
//			if(u.getDni()== id)
//				return u;
		}
		return null;
	}
	
	
	
	
	public int size(){
		return cuotas.size();
	}

	public void actualizarBD() 
	{
//		CuotaSRV.grabarCuota(cuotas);
		
	}
}
