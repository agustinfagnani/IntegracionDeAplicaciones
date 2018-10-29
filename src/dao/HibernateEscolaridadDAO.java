
package dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.escuela.negocio.Escolaridad;
import com.escuela.negocio.Factura;

import bean.Cliente;
import java.util.List;

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
	
	public void grabarEscolaridad(List<Escolaridad> escolaridad){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Escolaridad escol:escolaridad)
			session.merge(escol);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Cliente> leerClientes(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Cliente> list = session.createQuery("from Cliente").list();
		session.close();
		return list;
	}

	public void grabarCliente(Cliente cli) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(cli); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

}
