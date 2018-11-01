package controller;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.json.JSONException;
import Repositorio.TDAManejoDatos;
import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateEmpleadoDAO;
import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateFacturaDAO;
import bean.dao.HibernateTitularDAO;
import exception.AdicionalNoExisteException;
import exception.AdicionalYaAsignadoException;
import exception.AlumnoNoExisteException;
import exception.EmpleadoYaExisteException;
import exception.ErrorConeccionPresenciaException;
import exception.EscolaridadNoExisteException;
import exception.FacturaNoExisteException;
import exception.PeriodoNoFacturadoException;
import exception.SistemaLiquidacionException;
import exception.TitularNoExisteException;
import exception.TitularYaExisteException;
import integracion.PostLiquidacion;
import integracion.PostPresencia;
import negocio.Escolaridad;
import negocio.Factura;
import negocio.TipoDePago;
import negocio.Titular;
import negocio.Adicional;
import negocio.Alumno;
import negocio.Empleado;




public class SistemaEscuela extends UnicastRemoteObject implements TDAManejoDatos {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	private final String miCuit = "30715087738";
	

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
		Alumno newAlumno = new Alumno(nombre, direccion, mail, telefono, e);
		t.addAlumno(newAlumno);
		HibernateTitularDAO.getInstancia().grabarTitular(t);
		
		
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
	

	public void crearEmpleado(int DNI, String cargo, String nombre, String apellido, String direccion, String mail, String telefono, float salario, String cbu) throws EmpleadoYaExisteException, SistemaLiquidacionException, ErrorConeccionPresenciaException {
		if(HibernateEmpleadoDAO.getInstancia().buscarEmpleado(DNI) != null)
			throw new EmpleadoYaExisteException();
		Empleado newEmpleado = new Empleado(DNI, cargo, nombre, apellido, direccion, mail, telefono, salario, cbu);
		try {
			new PostLiquidacion(newEmpleado);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new PostPresencia(newEmpleado); 
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(newEmpleado);
		
	}
	
	public void modificarEmpleado(int legajo, String cargo, String direccion, String mail, String telefono, float salario) {
		
		
		
	}
	
	public void bajaEmpleado(int legajo) {
		
	}
	
	public void crearTitular(String nombre, int dNI, String direccion, String mail, String telefono, TipoDePago tipoDePago) throws TitularYaExisteException {
		if(HibernateTitularDAO.getInstancia().buscarTitular(dNI) != null)
			throw new TitularYaExisteException();
		Titular newTitular = new Titular(nombre, dNI, direccion, mail, telefono, tipoDePago);	
		HibernateTitularDAO.getInstancia().grabarTitular(newTitular);
	
	}
	
	public void modificarTitular(int dNI, String direccion, String mail, String telefono) {
		
	}
	
	public void bajaTitular(int dNI) {
		
	}
	
	public Factura verFacturaTitular(int dni, int periodo, int anio) throws PeriodoNoFacturadoException, TitularNoExisteException {
		Titular a = HibernateTitularDAO.getInstancia().buscarTitular(dni);
		if(a==null)
			throw new TitularNoExisteException();
		Factura f = HibernateFacturaDAO.getInstancia().buscarFactura(periodo, anio, dni);
		if(f==null)
			throw new PeriodoNoFacturadoException();
		return f;
	}
	
	public void facturar(int periodo, int anio) {
		for(Titular a: HibernateTitularDAO.getInstancia().leerTitulares()) {
			if(HibernateFacturaDAO.getInstancia().buscarFactura(periodo, anio, a.getDNI()) == null) {
				Factura f = new Factura(a, periodo, anio);
				HibernateFacturaDAO.getInstancia().grabarFactura(f);
			}
		}
	}
	
	public void pagarFactura(int numero) throws FacturaNoExisteException {
		Factura f = HibernateFacturaDAO.getInstancia().buscarFactura(numero);
		if(f==null)
			throw new FacturaNoExisteException();
		HibernateFacturaDAO.getInstancia().grabarFactura(f);
	}
	
	public void asignarInscripcion(int legajo, int id) throws AlumnoNoExisteException, AdicionalNoExisteException, AdicionalYaAsignadoException {
		Alumno a = HibernateAlumnoDAO.getInstancia().buscarAlumno(legajo);
		if(a==null)
			throw new AlumnoNoExisteException();
		Adicional ad = HibernateAdicionalDAO.getInstancia().buscarAdicional(id);
		if(ad==null)
			throw new AdicionalNoExisteException();
		
		for(Adicional adi: a.getAdicionales()) {
			if(adi.getId() == id) {
				throw new AdicionalYaAsignadoException();
			}
		}
		a.addAdicional(ad);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(a);
	}
	
	
}
