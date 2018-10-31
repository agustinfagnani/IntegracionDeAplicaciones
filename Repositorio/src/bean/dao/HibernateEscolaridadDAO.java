
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Escolaridad;


public class HibernateEscolaridadDAO {
	private static HibernateEscolaridadDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateEscolaridadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateEscolaridadDAO();
		} 
		return instancia;
	}
	
//	public void grabarEscolaridad(List<Escolaridad> escolaridad){
//		Session session = sf.openSession();
//		session.beginTransaction();
//		for(Escolaridad escol:escolaridad)
//			session.merge(escol);
//		session.flush();
//		session.getTransaction().commit();
//		session.close();
//}
	
	public List<Escolaridad> leerEscolaridads(){
		Session session = sf.openSession();
		List<Escolaridad> list = session.createQuery("from Escolaridad").list();
		session.close();
		return list;
	}

	public void grabarEscolaridad(Escolaridad esc) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		//session.merge(esc); // bajamos los cambios es decir actualiza de la base de datos
		session.saveOrUpdate(esc);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Escolaridad buscarEscolaridad(int idEscolaridad){
		Session session = sf.openSession();
		Query<Escolaridad> query = session.createQuery("From Escolaridad where id = :id");
		query.setParameter("id", idEscolaridad);
		Escolaridad escolaridad = (Escolaridad) query.uniqueResult();
		session.close();
		
		return escolaridad;
	}

}
