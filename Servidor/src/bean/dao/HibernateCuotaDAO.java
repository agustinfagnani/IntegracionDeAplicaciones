
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import negocio.Cuota;

public class HibernateCuotaDAO {
	private static HibernateCuotaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateCuotaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateCuotaDAO();
		} 
		return instancia;
	}
	
	public void grabarCuotas(List<Cuota> cuotas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Cuota cuota:cuotas)
			session.merge(cuota);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Cuota> leerCuotas(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Cuota> list = session.createQuery("from Cuota").list();
		session.close();
		return list;
	}

	public void grabarCuota(Cuota c) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(c); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

}
