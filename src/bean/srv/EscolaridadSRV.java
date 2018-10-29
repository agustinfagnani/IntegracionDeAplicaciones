package bean.srv;


import java.util.List;

import bean.dao.HibernateEscolaridadDAO;
import negocio.Escolaridad;


public class EscolaridadSRV {
	private static HibernateEscolaridadDAO dao;
	
	static {
		dao = HibernateEscolaridadDAO.getInstancia();
	}
	
	public static void grabarEscolaridad(Escolaridad esc){
		dao.grabarEscolaridad(esc);
	}
	
	//public static void grabarEscolaridads(List<Escolaridad> esc){
	//	dao.grabarEscolaridad(esc);
	//}
	
	public static List<Escolaridad>leerEscolaridad()
	{
		return dao.leerEscolaridads();
	}
	
}