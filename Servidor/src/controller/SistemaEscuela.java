package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.List;

import Repositorio.TDAManejoDatos;
import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateEmpleadoDAO;
import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateFacturaDAO;
import bean.dao.HibernateTitularDAO;
import negocio.Escolaridad;
import negocio.Factura;
import negocio.Titular;
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
			int idEscolarida) {
		//AGREGAR FUNCIONES BUSCAR TITULAR Y BUSCAR ESCOLARIDAD AL DAO
		Titular t = HibernateTitularDAO.getInstancia().buscarTitular(dniTitular);
		Escolaridad e = HibernateEscolaridadDAO.getInstancia().leerEscolaridads().get(0);
		Alumno newAlumno = new Alumno(nombre, t, direccion, mail, telefono, e);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(newAlumno);
		
		
	}
	
	public List<Titular> getTitulares(){
		return HibernateTitularDAO.getInstancia().leerTitulares();
		
	}
	
	public List<Escolaridad> getEscolaridades(){
		return HibernateEscolaridadDAO.getInstancia().leerEscolaridads();
		
	}
	
	public void modificarAlumno(int legajo, int escolaridad, String direccion, String mail,String telefono, String telefonoContacto) {
		
	}
	
	public void bajaAlumno(int legajo) {
		
	}
	

	public void crearEmpleado(int DNI, String cargo, String nombre, String direccion, String mail, String telefono, float salario) {
		
		Empleado newEmpleado = new Empleado(DNI, cargo, nombre, direccion, mail, telefono, salario);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(newEmpleado);
		
	}
	
	public void modificarEmpleado(int legajo, String cargo, String direccion, String mail, String telefono, float salario) {
		
		
		
	}
	
	public void bajaEmpleado(int legajo) {
		
	}
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono) {
		Titular newTitular = new Titular(nombre, dNI, direccion, mail, telefono);	
		HibernateTitularDAO.getInstancia().grabarTitular(newTitular);
	
	}
	
	public void modificarTitular(int dNI, String direccion, String mail, String telefono) {
		
	}
	
	public void bajaTitular(int dNI) {
		
	}
	
	public void facturarAlumno(int legajo) {
		
	}
	
	public void pagarFactura(int numero) {
		List<Factura> listadoFactura = HibernateFacturaDAO.getInstancia().leerFactura();
		Factura f = null;/// HAY QUE TRAER LA FACTURA 
		f.setFechaPago(LocalDateTime.now());
		HibernateFacturaDAO.getInstancia().grabarFactura(f);
	}
	
	public void asignarCuota(int legajo, int id) {
		// HAY QUE TRAER LA CUOTA
//		Alumno a = HibernateCuotaDAO.getInstancia().find(legajo);
//		Cuota c = CuotaDAO.find(id);
//		a.addCuota(c);
//		AlumnoDAO.save(a);
	}
}
