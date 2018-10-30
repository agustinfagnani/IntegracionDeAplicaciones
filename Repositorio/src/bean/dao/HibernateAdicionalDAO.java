
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Adicional;

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
	
	public Adicional buscarAdicional(int idAdicional){
		Session session = sf.openSession();
		Query<Adicional> query = session.createQuery("From Adicional where id = :id");
		query.setParameter("id", idAdicional);
		Adicional adicional = (Adicional) query.uniqueResult();
		session.close();
		
		return adicional;
	}

	public List<Integer> adicionalPorAlumno (int numeroAlumno){
		Session session = sf.openSession();
		Query query = session.createQuery("SELECT id FROM alumno_adicional WHERE legajo = num");
		query.setParameter("num", numeroAlumno);
		List<Integer> lista = query.list();
		
		return lista;
		
		
	}
	
}
