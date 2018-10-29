package bean.srv;


import java.util.List;

import bean.dao.HibernateCuotaDAO;
import negocio.Cuota;


public class CuotaSRV {
	private static HibernateCuotaDAO dao;
	
	static {
		dao = HibernateCuotaDAO.getInstancia();
	}
	
	public static void grabarCuota(Cuota c){
		dao.grabarCuota(c);
	}
	
	public static void grabarCuotas(List<Cuota> cuotas){
		dao.grabarCuotas(cuotas);
	}
	
	public static List<Cuota>leerCuotas()
	{
		return dao.leerCuotas();
	}
	
}