package Servidor;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import Repositorio.TDAManejoDatos;
import bean.dao.HibernateAlumnoDAO;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Titular;



public class GestionAlumnos extends UnicastRemoteObject implements TDAManejoDatos {

	private static final long serialVersionUID = 1L;
	private ArrayList<Alumno> alumnos;

	public GestionAlumnos() throws RemoteException {
		super();	
		
		Titular t = new Titular("Titular1", 123, "direccion1", "mail", "telefono1");
		Escolaridad esc1 = new Escolaridad("Turno mañana", 123);
		alumnos = new ArrayList<Alumno>();
		Alumno alumno = new Alumno("Alumno1", t, "dire1", "mail", "telefono", esc1);
		alumnos.add(alumno);
		Alumno alumno2 = new Alumno("Alumno2", t, "dire2", "mail2", "telefono2", esc1);
		alumnos.add(alumno2);
		Alumno alumno3 = new Alumno("Alumno3", t, "dire3", "mail3", "telefono3", esc1);
		alumnos.add(alumno3);
		Alumno alumno4 = new Alumno("Alumno4", t, "dire4", "mail4", "telefono4", esc1);
		alumnos.add(alumno4);

	}

	public void envioAlumno(Alumno alumno) throws RemoteException 
	{
		alumnos.add(alumno);
	}
	
	public Alumno obtengoAlumno(int legajo) {
		Alumno alumBuscar = null;
		for (Alumno c : alumnos) {
			if (c.sosAlumn(legajo))
				alumBuscar = c;
		}
		alumBuscar = HibernateAlumnoDAO.getInstancia().cargarAlumno(legajo);

		return alumBuscar;
	}


//	public Alumno obtengoAlumno(int nroAlumno) throws RemoteException {
//		Alumno aux;
////		for(Iterator<Alumno> i=alumnos.iterator();i.hasNext();)
////		{
////			aux = i.next();
////			if(aux.getLegajo()==nroAlumno)
////				return aux;
////		}
//		
//		int i = 0;
//		while ( i < alumnos.size()) {
//			if(aux.getLegajo()==nroAlumno)
//				return aux;
//		}
//		throw new RemoteException("No encontre al alumno");
//	}

	public ArrayList<Alumno> obtengoAlumnos() throws RemoteException 
	{
		return alumnos;
	}

	@Override
	public int cantidadAlumnos() throws RemoteException {
		// TODO Auto-generated method stub
		return alumnos.size();
	}
}
