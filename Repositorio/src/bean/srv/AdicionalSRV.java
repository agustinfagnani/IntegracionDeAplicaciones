package bean.srv;


import java.util.List;

import bean.dao.HibernateAdicionalDAO;
import negocio.Adicional;



public class AdicionalSRV {
	private static HibernateAdicionalDAO dao;
	
	static {
		dao = HibernateAdicionalDAO.getInstancia();
	}
	
	public static void grabarAdicional(Adicional adi){
		dao.grabarAdicional(adi);
	}
	
	public static void grabarAdicionales(List<Adicional> adicionales){
		dao.grabarAdicional(adicionales);
	}
	
	public static List<Adicional>leerAdicionales()
	{
		return dao.leerAdicionales();
	}
	
}