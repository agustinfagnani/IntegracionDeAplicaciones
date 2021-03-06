
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import negocio.ItemFactura;

public class HibernateItemFacturaDAO {
	private static HibernateItemFacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateItemFacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateItemFacturaDAO();
		} 
		return instancia;
	}

	
	public List<ItemFactura> leerItemFactura(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<ItemFactura> list = session.createQuery("from ItemFactura").list();
		session.close();
		return list;
	}

	public void grabarItemFactura(ItemFactura itemfact) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(itemfact); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

}
