
package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import negocio.Alumno;

public class HibernateAlumnoDAO {
	private static HibernateAlumnoDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateAlumnoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateAlumnoDAO();
		} 
		return instancia;
	}
	
	public void grabarAlumno(List<Alumno> alumnos){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Alumno alumno:alumnos)
			session.merge(alumno);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Alumno cargarAlumno(int legajo) {
		Session session = sf.openSession();
		session.beginTransaction();
		Alumno alumn = session.get(Alumno.class, legajo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		if (alumn != null)
			return alumn;
		return null;
	}

	
	public List<Alumno> leerAlumnos(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Alumno> list = session.createQuery("from Alumno").list();
		session.close();
		return list;
	}

	public void grabarAlumno(Alumno Alumn) 
	{
		Session session = sf.openSession(); // session factory
		session.beginTransaction();
		session.merge(Alumn); // bajamos los cambios es decir actualiza de la base de datos
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Alumno buscarAlumno(int legajoAlumno){
		Session session = sf.openSession();
		Query<Alumno> query = session.createQuery("From Alumno where legajo = :legajo");
		query.setParameter("legajo", legajoAlumno);
		Alumno alumno = (Alumno) query.uniqueResult();
		session.close();
		
		return alumno;
	}

}
