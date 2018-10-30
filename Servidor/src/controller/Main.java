package controller;

import java.rmi.RemoteException;

import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateTitularDAO;
import hbt.HibernateUtil;
import negocio.Escolaridad;
import negocio.Titular;

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
	sistemaEscuela.crearTitular("Roberto Rodriguez", 18764389, "Belgrano 234", "aa@hotmail.com", "2222");
	sistemaEscuela.crearTitular("Ricardo Benitez", 15765098, "Sarmiento 234", "aa@gmail.com", "333");
	
	Escolaridad esc1 = new Escolaridad("Turno maniana", 1500);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 1000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 2000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	
	sistemaEscuela.crearAlumno("Alumno1", 0, "dire1", "mail", "telefono", 0);
	sistemaEscuela.crearAlumno("Alumno2", 0, "dire2", "mail2","telefono", 0);
	sistemaEscuela.crearAlumno("Alumno3", 0, "dire3", "mail3","telefono", 0);
	
	sistemaEscuela.crearEmpleado(12875398, "Profesor", "Albert Einstein", "Av 9 de Julio 12", "asd@asd.com", "4556",20000);
	sistemaEscuela.crearEmpleado(33435678, "Profesor", "Jirafales", "Av 9 de Julio 13", "asd2@asd.com", "5555",25000);
	sistemaEscuela.crearEmpleado(30987777, "Kiosquero", "Cacho", "Av 9 de Julio 14", "asd3@asd.com", "6666",50000);

	
	}

}
