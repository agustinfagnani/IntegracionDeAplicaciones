
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Factura;


public class HibernateFacturaDAO {
	private static HibernateFacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateFacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateFacturaDAO();
		} 
		return instancia;
	}
	
	public void grabarFactura(List<Factura> facturas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Factura factura:facturas)
			session.merge(factura);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Factura> leerFactura(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Factura> list = session.createQuery("from Factura").list();
		session.close();
		return list;
	}

	public void grabarFactura(Factura fact) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(fact); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Factura buscarFactura(int numeroFactura){
		Session session = sf.openSession();
		Query<Factura> query = session.createQuery("From Factura where numero = :numero");
		query.setParameter("numero", numeroFactura);
		Factura factura = (Factura) query.uniqueResult();
		session.close();
		
		return factura;
	}
	
	public Factura buscarFactura(int periodo, int anio, int dniTitular){
		Session session = sf.openSession();
		Query<Factura> query = session.createQuery("From Factura where periodo = :periodo and anio = :anio and dni = :dni");
		query.setParameter("periodo", periodo);
		query.setParameter("anio", anio);
		query.setParameter("dni", dniTitular);
		Factura factura = (Factura) query.uniqueResult();
		session.close();
		
		return factura;
	}
	
}
