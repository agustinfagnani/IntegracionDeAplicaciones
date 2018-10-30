package controller;

import java.rmi.RemoteException;

import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateEscolaridadDAO;
import hbt.HibernateUtil;
import negocio.Adicional;
import negocio.Escolaridad;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	HibernateUtil.getSessionFactory();
	SistemaEscuela sistemaEscuela = null;
	try {
		sistemaEscuela = new SistemaEscuela();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
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
	sistemaEscuela.crearTitular("Alfredo Fernandez", 123, "San Martin 234", "aa@yahoo.com", "1111");
	sistemaEscuela.crearTitular("Roberto Rodriguez", 345, "Belgrano 234", "aa@hotmail.com", "2222");
	sistemaEscuela.crearTitular("Ricardo Benitez", 567, "Sarmiento 234", "aa@gmail.com", "333");
	
	Escolaridad esc1 = new Escolaridad("Turno maniana", 1500);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 1000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 2000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	
	sistemaEscuela.crearAlumno("Alumno1", 123, "dire1", "mail", "telefono", esc1.getId());
	sistemaEscuela.crearAlumno("Alumno2", 123, "dire2", "mail2","telefono", esc1.getId());
	sistemaEscuela.crearAlumno("Alumno3", 345, "dire3", "mail3","telefono", esc2.getId());
	
	sistemaEscuela.crearEmpleado(12875398, "Profesor", "Albert Einstein", "Av 9 de Julio 12", "asd@asd.com", "4556",20000);
	sistemaEscuela.crearEmpleado(33435678, "Profesor", "Jirafales", "Av 9 de Julio 13", "asd2@asd.com", "5555",25000);
	sistemaEscuela.crearEmpleado(30987777, "Kiosquero", "Cacho", "Av 9 de Julio 14", "asd3@asd.com", "6666",50000);

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
	
	sistemaEscuela.asginarInscripcion(1,2);
	sistemaEscuela.asginarInscripcion(1,3);
	sistemaEscuela.asginarInscripcion(1,4);
	
	sistemaEscuela.facturarAlumno(1, "A");
	
	
	}
	
	

}
