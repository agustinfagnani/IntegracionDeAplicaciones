package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateTitularDAO;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Titular;



public interface TDAManejoDatos extends Remote 
{
	public void crearAlumno(String nombre, int dniTitular, String direccion, String mail, String telefono,
			int idEscolarida) throws RemoteException;
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono) throws RemoteException;
	
	public void crearEmpleado(int DNI, String cargo, String nombre, String direccion, String mail, String telefono, float salario)  throws RemoteException;
	
	public void pagarFactura(int numero)  throws RemoteException;
	
	public List<Titular> getTitulares() throws RemoteException;
	
	public List<Escolaridad> getEscolaridades() throws RemoteException;
}
