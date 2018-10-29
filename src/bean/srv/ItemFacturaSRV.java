package bean.srv;


import java.util.List;

import bean.dao.HibernateItemFacturaDAO;
import negocio.ItemFactura;


public class ItemFacturaSRV {
	private static HibernateItemFacturaDAO dao;
	
	static {
		dao = HibernateItemFacturaDAO.getInstancia();
	}
	
	public static void grabarItemFactura(ItemFactura ift){
		dao.grabarItemFactura(ift);
	}
	
	public static void grabarItemFactura(List<ItemFactura> itemFactura){
		dao.grabarItemFactura(itemFactura);
	}
	
	public static List<ItemFactura>leerItemFacturas()
	{
		return dao.leerItemFactura();
	}
	
}