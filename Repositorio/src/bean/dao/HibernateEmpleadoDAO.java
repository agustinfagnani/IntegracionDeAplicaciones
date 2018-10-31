
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Empleado;


public class HibernateEmpleadoDAO {
	private static HibernateEmpleadoDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateEmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateEmpleadoDAO();
		} 
		return instancia;
	}
	
	public void grabarEmpleados(List<Empleado> empleados){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Empleado empleado:empleados)
			session.merge(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Empleado> leerEmpleados(){
		Session session = sf.openSession();
		List<Empleado> list = session.createQuery("from Empleado").list();
		session.close();
		return list;
	}

	public void grabarEmpleado(Empleado Emplead) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(Emplead); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Empleado buscarEmpleado(int dniEmpleado){
		Session session = sf.openSession();
		Query<Empleado> query = session.createQuery("From Empleado where dni = :dni");
		query.setParameter("dni", dniEmpleado);
		Empleado empleado = (Empleado) query.uniqueResult();
		session.close();
		
		return empleado;
	}

}
