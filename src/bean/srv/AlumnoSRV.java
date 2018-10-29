package bean.srv;


import java.util.List;
import bean.dao.HibernateAlumnoDAO;
import negocio.Alumno;


public class AlumnoSRV {
	private static HibernateAlumnoDAO dao;
	
	static {
		dao = HibernateAlumnoDAO.getInstancia();
	}
	
	public static void grabarAlumno(Alumno alumno){
		dao.grabarAlumno(alumno);
	}
	
	public static void grabarAlumnos(List<Alumno> alumnos){
		dao.grabarAlumno(alumnos);
	}
	
	public static List<Alumno>leerAlumnos()
	{
		return dao.leerAlumnos();
	}
	
}