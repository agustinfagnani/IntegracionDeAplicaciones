package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateTitularDAO;
import exception.AlumnoNoExisteException;
import exception.EmpleadoYaExisteException;
import exception.EscolaridadNoExisteException;
import exception.PeriodoNoFacturadoException;
import exception.TitularNoExisteException;
import exception.TitularYaExisteException;
import negocio.Adicional;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Factura;
import negocio.Titular;



public interface TDAManejoDatos extends Remote 
{
	public void crearAlumno(String nombre, int dniTitular, String direccion, String mail, String telefono,
			int idEscolarida) throws RemoteException, TitularNoExisteException, EscolaridadNoExisteException;
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono) throws RemoteException, TitularYaExisteException;
	
	public void crearEmpleado(int DNI, String cargo, String nombre, String direccion, String mail, String telefono, float salario)  throws RemoteException, EmpleadoYaExisteException;
	
	public void pagarFactura(int numero)  throws RemoteException;
	
	public List<Titular> getTitulares() throws RemoteException;
	
	public List<Escolaridad> getEscolaridades() throws RemoteException;
	
	public List<Alumno> getAlumnos() throws RemoteException;
	
	public List<Adicional> getAdicionales() throws RemoteException;
	
	public void asignarInscripcion(int legajo, int id) throws RemoteException;
	
	public Factura verFacturaTitular(int dni, int periodo, int anio) throws RemoteException, PeriodoNoFacturadoException, TitularNoExisteException;
	
	public void facturar(int periodo, int anio) throws RemoteException;
}
