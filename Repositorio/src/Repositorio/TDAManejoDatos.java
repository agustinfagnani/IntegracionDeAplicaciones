package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import exception.AdicionalNoExisteException;
import exception.AdicionalYaAsignadoException;
import exception.AlumnoNoExisteException;
import exception.EmpleadoYaExisteException;
import exception.EscolaridadNoExisteException;
import exception.FacturaNoExisteException;
import exception.PeriodoNoFacturadoException;
import exception.TitularNoExisteException;
import exception.TitularYaExisteException;
import negocio.Adicional;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Factura;
import negocio.TipoDePago;
import negocio.Titular;



public interface TDAManejoDatos extends Remote 
{
	public void crearAlumno(String nombre, int dniTitular, String direccion, String mail, String telefono,
			int idEscolarida) throws RemoteException, TitularNoExisteException, EscolaridadNoExisteException;
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono, TipoDePago tipoDePago) throws RemoteException, TitularYaExisteException;
	
	public void crearEmpleado(int DNI, String cargo, String nombre, String apellido, String direccion, String mail, String telefono, float salario)  throws RemoteException, EmpleadoYaExisteException;
	
	public void pagarFactura(int numero)  throws RemoteException, FacturaNoExisteException;
	
	public List<Titular> getTitulares() throws RemoteException;
	
	public List<Escolaridad> getEscolaridades() throws RemoteException;
	
	public List<Alumno> getAlumnos() throws RemoteException;
	
	public List<Adicional> getAdicionales() throws RemoteException;
	
	public void asignarInscripcion(int legajo, int id) throws RemoteException, AlumnoNoExisteException, AdicionalNoExisteException, AdicionalYaAsignadoException;
	
	public Factura verFacturaTitular(int dni, int periodo, int anio) throws RemoteException, PeriodoNoFacturadoException, TitularNoExisteException;
	
	public void facturar(int periodo, int anio) throws RemoteException;
}
