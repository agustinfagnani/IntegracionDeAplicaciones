package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

import bean.dao.HibernateAlumnoDAO;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Titular;



public interface TDAManejoDatos extends Remote 
{
	public void crearAlumno(String nombre, int dniTitular, String direccion, String mail, String telefono,
			int idEscolarida) throws RemoteException;
}
