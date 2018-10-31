package controller;

import java.rmi.RemoteException;

import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateEscolaridadDAO;
import exception.AdicionalNoExisteException;
import exception.AdicionalYaAsignadoException;
import exception.AlumnoNoExisteException;
import exception.EmpleadoYaExisteException;
import exception.EscolaridadNoExisteException;
import exception.TitularNoExisteException;
import exception.TitularYaExisteException;
import hbt.HibernateUtil;
import negocio.Adicional;
import negocio.Credito;
import negocio.Deposito;
import negocio.Escolaridad;
import negocio.TipoDePago;

public class Main {

	public static void main(String[] args) {
		
	HibernateUtil.getSessionFactory();
	SistemaEscuela sistemaEscuela = null;
	try {
		sistemaEscuela = new SistemaEscuela();
	} catch (RemoteException e) {
		e.printStackTrace();
	}
	/*
	Titular t = new Titular("Titular1", 123, "direccion1", "mail", "telefono1");
	HibernateTitularDAO.getInstancia().grabarTitular(t);
	Escolaridad esc1 = new Escolaridad("Turno ma�ana", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	*/
	try {
		
		TipoDePago tipo1 = new Credito("1234567812345678", 567);
		TipoDePago tipo2 = new Deposito("1234567891234567891234");
		TipoDePago tipo3 = new Credito("9876543298765432", 001);
		
		
		sistemaEscuela.crearTitular("Alfredo Fernandez", 123, "San Martin 234", "aa@yahoo.com", "1111", tipo1);
		sistemaEscuela.crearTitular("Ricardo Benitez", 567, "Sarmiento 234", "aa@gmail.com", "333", tipo2);
		sistemaEscuela.crearTitular("Roberto Rodriguez", 345, "Belgrano 234", "aa@hotmail.com", "2222", tipo3);

	} catch (TitularYaExisteException e1) {
		e1.printStackTrace();
	}
	
	
	Escolaridad esc1 = new Escolaridad("Turno maniana", 1500);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 1000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 2000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	

	try {
		sistemaEscuela.crearAlumno("Juan Perez", 123, "Su Casa", "mail@aa.com","4256575", esc1.getId());
		sistemaEscuela.crearAlumno("Osvaldo Dominguez", 123, "San Martin 5775", "mail2@bb.com", "476768", esc1.getId());
		sistemaEscuela.crearAlumno("Esteban Alvarez", 345, "abajo de un puente", "mail3@cc.com","498327362", esc2.getId());
	} catch (TitularNoExisteException e) {
		e.printStackTrace();
	} catch (EscolaridadNoExisteException e) {
		e.printStackTrace();
	}

	
	try {
		sistemaEscuela.crearEmpleado(12875398, "Profesor", "Albert", "Einstein", "Av 9 de Julio 12", "asd@asd.com", "4556",20000);
		sistemaEscuela.crearEmpleado(33435678, "Profesor", "Profesor", "Jirafales", "Av 9 de Julio 13", "asd2@asd.com", "5555",25000);
		sistemaEscuela.crearEmpleado(30987777, "Kiosquero", "Cacho", "Fernandez", "Av 9 de Julio 14", "asd3@asd.com", "6666",50000);
	} catch (EmpleadoYaExisteException e) {
		e.printStackTrace();
	}
	

	Adicional ad1 = new Adicional("Futbol", 200);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad1);
	Adicional ad2 = new Adicional("Ingles", 200);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad2);
	Adicional ad3 = new Adicional("Desayuno", 100);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad3);
	Adicional ad4 = new Adicional("almuerzo", 150);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad4);
	Adicional ad5 = new Adicional("Merienda", 100);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad5);
	Adicional ad6 = new Adicional("Teatro", 200);
	HibernateAdicionalDAO.getInstancia().grabarAdicional(ad6);
	
	try {
		sistemaEscuela.asignarInscripcion(1,2);
		sistemaEscuela.asignarInscripcion(1,3);
		sistemaEscuela.asignarInscripcion(1,4);
	} catch (AlumnoNoExisteException | AdicionalNoExisteException e) {
		e.printStackTrace();
	} catch (AdicionalYaAsignadoException e) {
		e.printStackTrace();
	}
	
	sistemaEscuela.facturar(11, 2017);
	
	
	}
	
	

}
