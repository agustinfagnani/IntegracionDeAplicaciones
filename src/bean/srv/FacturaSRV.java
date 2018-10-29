package bean.srv;


import java.util.List;

import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateFacturaDAO;
import negocio.Factura;


public class FacturaSRV {
	private static HibernateFacturaDAO dao;
	
	static {
		dao = HibernateFacturaDAO.getInstancia();
	}
	
	public static void grabarFactura(Factura fac){
		dao.grabarFactura(fac);
	}
	
	public static void grabaFacturas(List<Factura> fac){
		dao.grabarFactura(fac);
	}
	
	public static List<Factura>leerFacturas()
	{
		return dao.leerFactura();
	}
	
}