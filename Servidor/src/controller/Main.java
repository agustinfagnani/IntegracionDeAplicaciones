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
	Titular t = new Titular("Titular1", 123, "direccion1", "mail", "telefono1");
	HibernateTitularDAO.getInstancia().grabarTitular(t);
	Escolaridad esc1 = new Escolaridad("Turno ma�ana", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	sistemaEscuela.crearAlumno("Alumno1", 0, "dire1", "mail", "telefono", 0);
	sistemaEscuela.crearAlumno("Alumno2", 0, "dire2", "mail2","telefono", 0);
	sistemaEscuela.crearAlumno("Alumno3", 0, "dire3", "mail3","telefono", 0);
	
	
	
	}

}
