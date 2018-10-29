package controller;

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
	SistemaEscuela  sistemaEscuela = new SistemaEscuela();
	Titular t = new Titular("Titular1", 123, "direccion1", "mail", "telefono1");
	HibernateTitularDAO.getInstancia().grabarTitular(t);
	Escolaridad esc1 = new Escolaridad("Turno mañana", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 123);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	sistemaEscuela.crearAlumno("Alumno1", t, "dire1", "mail", "telefono", esc1);
	sistemaEscuela.crearAlumno("Alumno2", t, "dire2", "mail2","telefono", esc2);
	sistemaEscuela.crearAlumno("Alumno3", t, "dire3", "mail3","telefono", esc3);
	
	
	
	}

}
