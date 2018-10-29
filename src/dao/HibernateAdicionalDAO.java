
package dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.escuela.negocio.Adicional;

import bean.Cliente;
import java.util.List;

public class HibernateAdicionalDAO {
	private static HibernateAdicionalDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateAdicionalDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateAdicionalDAO();
		} 
		return instancia;
	}
	
	public void grabarAdicional(List<Adicional> adicionales){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Adicional adicional:adicionales)
			session.merge(adicional);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Adicional> leerAdicionales(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Adicional> list = session.createQuery("from Adicional").list();
		session.close();
		return list;
	}

	public void grabarAdicional(Adicional adic) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(adic); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

}
