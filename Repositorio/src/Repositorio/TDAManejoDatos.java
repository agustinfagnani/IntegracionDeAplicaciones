package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

import negocio.Alumno;



public interface TDAManejoDatos extends Remote 
{
	/* retorna un alumno */
	public Alumno obtengoAlumno(int nroAlumno) throws RemoteException;
	
	/* recibe un alumno */ 
	public void envioAlumno(Alumno alumno)throws RemoteException;
	 
	/* retorna todos los alumnos */ 
	public ArrayList<Alumno> obtengoAlumnos()throws RemoteException;
	
	public int cantidadAlumnos() throws RemoteException;
}
