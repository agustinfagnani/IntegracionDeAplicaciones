package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Repositorio.TDAManejoDatos;
import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateEmpleadoDAO;
import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateFacturaDAO;
import bean.dao.HibernateTitularDAO;
import exception.AlumnoNoExisteException;
import exception.EmpleadoYaExisteException;
import exception.EscolaridadNoExisteException;
import exception.PeriodoNoFacturadoException;
import exception.TitularNoExisteException;
import exception.TitularYaExisteException;
import negocio.Escolaridad;
import negocio.Factura;
import negocio.Titular;
import negocio.Adicional;
import negocio.Alumno;
import negocio.Empleado;




public class SistemaEscuela extends UnicastRemoteObject implements TDAManejoDatos {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	

	public SistemaEscuela() throws RemoteException {
		
	}

	public void crearAlumno(String nombre, int dniTitular, String direccion, String mail, String telefono,
			int idEscolarida) throws TitularNoExisteException, EscolaridadNoExisteException {
		Titular t = HibernateTitularDAO.getInstancia().buscarTitular(dniTitular);
		if(t==null)
			throw new TitularNoExisteException();
		Escolaridad e = HibernateEscolaridadDAO.getInstancia().buscarEscolaridad(idEscolarida);
		if(e==null)
			throw new EscolaridadNoExisteException();
		Alumno newAlumno = new Alumno(nombre, t, direccion, mail, telefono, e);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(newAlumno);
		
		
	}
	
	public List<Titular> getTitulares(){
		return HibernateTitularDAO.getInstancia().leerTitulares();
		
	}
	
	public List<Escolaridad> getEscolaridades(){
		return HibernateEscolaridadDAO.getInstancia().leerEscolaridads();
		
	}
	
	public List<Alumno> getAlumnos(){
		return HibernateAlumnoDAO.getInstancia().leerAlumnos();
		
	}
	
	public List<Adicional> getAdicionales(){
		return HibernateAdicionalDAO.getInstancia().leerAdicionales();
		
	}
	
	public void modificarAlumno(int legajo, int escolaridad, String direccion, String mail,String telefono, String telefonoContacto) {
		
	}
	
	public void bajaAlumno(int legajo) {
		
	}
	

	public void crearEmpleado(int DNI, String cargo, String nombre, String direccion, String mail, String telefono, float salario) throws EmpleadoYaExisteException {
		if(HibernateEmpleadoDAO.getInstancia().buscarEmpleado(DNI) == null)
			throw new EmpleadoYaExisteException();
		Empleado newEmpleado = new Empleado(DNI, cargo, nombre, direccion, mail, telefono, salario);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(newEmpleado);
		
	}
	
	public void modificarEmpleado(int legajo, String cargo, String direccion, String mail, String telefono, float salario) {
		
		
		
	}
	
	public void bajaEmpleado(int legajo) {
		
	}
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono) throws TitularYaExisteException {
		if(HibernateTitularDAO.getInstancia().buscarTitular(dNI) == null)
			throw new TitularYaExisteException();
		Titular newTitular = new Titular(nombre, dNI, direccion, mail, telefono);	
		HibernateTitularDAO.getInstancia().grabarTitular(newTitular);
	
	}
	
	public void modificarTitular(int dNI, String direccion, String mail, String telefono) {
		
	}
	
	public void bajaTitular(int dNI) {
		
	}
	
	public Factura verFacturaAlumno(int legajo, int periodo, int anio) throws AlumnoNoExisteException, PeriodoNoFacturadoException {
		Alumno a = HibernateAlumnoDAO.getInstancia().buscarAlumno(legajo);
		if(a==null)
			throw new AlumnoNoExisteException();
		Factura f = HibernateFacturaDAO.getInstancia().buscarFactura(periodo, anio, legajo);
		if(f==null)
			throw new PeriodoNoFacturadoException();
		return f;
	}
	
	public void facturar(int periodo, int anio) {
		for(Alumno a: HibernateAlumnoDAO.getInstancia().leerAlumnos()) {
			if(HibernateFacturaDAO.getInstancia().buscarFactura(periodo, anio, a.getLegajo()) == null) {
				Factura f = new Factura(a, periodo, anio);
				HibernateFacturaDAO.getInstancia().grabarFactura(f);
			}
		}
	}
	
	public void pagarFactura(int numero) {
		Factura f = HibernateFacturaDAO.getInstancia().buscarFactura(numero);
		
		HibernateFacturaDAO.getInstancia().grabarFactura(f);
	}
	
	public void asginarInscripcion(int legajo, int id) {
		Alumno a = HibernateAlumnoDAO.getInstancia().buscarAlumno(legajo);
		Adicional ad = HibernateAdicionalDAO.getInstancia().buscarAdicional(id);
		a.addAdicional(ad);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(a);
	}
}
