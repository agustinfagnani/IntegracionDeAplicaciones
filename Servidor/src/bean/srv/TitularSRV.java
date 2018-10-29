package bean.srv;


import java.util.List;

import bean.dao.HibernateTitularDAO;
import negocio.Titular;


public class TitularSRV {
	private static HibernateTitularDAO dao;
	
	static {
		dao = HibernateTitularDAO.getInstancia();
	}
	
	public static void grabarTitular(Titular ti){
		dao.grabarTitular(ti);
	}
	
	public static void grabarTitular(List<Titular> titular){
		dao.grabarTitular(titular);
	}
	
	public static List<Titular>leerTitulares()
	{
		return dao.leerTitulares();
	}
	
}