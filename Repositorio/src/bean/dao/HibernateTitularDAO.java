
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Titular;


public class HibernateTitularDAO {
	private static HibernateTitularDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateTitularDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateTitularDAO();
		} 
		return instancia;
	}
	
	public void grabarTitular(List<Titular> titulares){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Titular titular:titulares)
			session.merge(titular);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Titular> leerTitulares(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Titular> list = session.createQuery("from Titular").list();
		session.close();
		return list;
	}

	public void grabarTitular(Titular titu) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(titu); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Titular buscarTitular(int dniTitular){
		Session session = sf.openSession();
		Query<Titular> query = session.createQuery("From Titular where dni = :dni");
		query.setParameter("dni", dniTitular);
		Titular titular = (Titular) query.uniqueResult();
		session.close();
		
		return titular;
	}

}
