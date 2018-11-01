package controller;

import java.rmi.RemoteException;

import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateTitularDAO;
import hbt.HibernateUtil;
import negocio.Alumno;
import negocio.Credito;
import negocio.Deposito;
import negocio.Escolaridad;
import negocio.Titular;

public class CargaDatos {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		SistemaEscuela sistemaEscuela = null;
		try {
			sistemaEscuela = new SistemaEscuela();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	{
	Credito tipo1 = new Credito("1234567812345678", 567);
	Deposito tipo2 = new Deposito("1234567891234567891234");
	Credito tipo3 = new Credito("9876543298765432", 001);
	Credito tipo4 = new Credito("9999999999999999", 998);
	Deposito tipo5 = new Deposito("4444444444444444444444");
	Deposito tipo6 = new Deposito("5555555555555555555555");
	
	Titular titular1 = new Titular("Alfredo Fernandez", 123, "San Martin 234", "aa@yahoo.com", "1111", tipo1);
	Titular titular2 = new Titular("Ricardo Benitez", 567, "Sarmiento 234", "aa@gmail.com", "333", tipo2);
	Titular titular3 = new Titular("Roberto Rodriguez", 345, "Belgrano 234", "aa@hotmail.com", "2222", tipo3);
	Titular titular4 = new Titular("Leonardo DiCaprio", 444, "Av Libertador 1", "leo@gmail.com", "12347688", tipo4);
	Titular titular5 = new Titular("Pipa Benedetto", 555, "San Martin 111", "pipa@yahoo.com", "76785445", tipo5);
	Titular titular6 = new Titular("Roger Federer", 666, "Lugones 453", "roger@yahoo.com", "9856778", tipo6);
	
	
	HibernateTitularDAO.getInstancia().grabarTitular(titular1);
	HibernateTitularDAO.getInstancia().grabarTitular(titular2);
	HibernateTitularDAO.getInstancia().grabarTitular(titular3);
	HibernateTitularDAO.getInstancia().grabarTitular(titular4);
	HibernateTitularDAO.getInstancia().grabarTitular(titular5);
	HibernateTitularDAO.getInstancia().grabarTitular(titular6);
	
	
	Escolaridad esc1 = new Escolaridad("Turno maniana", 1500);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
	Escolaridad esc2 = new Escolaridad("Turno tarde", 1000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
	Escolaridad esc3 = new Escolaridad("Doble Turno", 2000);
	HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);
	
//	Alumno alumno1 = new Alumno("Juan Perez", 123, "Su Casa", "mail@aa.com","4256575", esc1.getId());
//	Alumno alumno2 = new Alumno("Osvaldo Dominguez", 123, "San Martin 5775", "mail2@bb.com", "476768", esc1.getId());
//	Alumno alumno3 = new Alumno("Esteban Alvarez", 345, "abajo de un puente", "mail3@cc.com","498327362", esc2.getId());
//	Alumno alumno4 = new Alumno("Chavo del 8", 444, "Barril", "chavo@566.com","437687787", esc3.getId());
//	Alumno alumno5 = new Alumno("Juan Perez", 123, "Su Casa", "mail@aa.com","4328767", esc2.getId());
//	Alumno alumno6 = new Alumno("Juan Perez", 123, "Su Casa", "mail@aa.com","6094378437438", esc1.getId());
	
	Alumno alumno1 = new Alumno("Juan Perez","Su Casa", "mail@aa.com","4256575", esc1);
	Alumno alumno2 = new Alumno("Osvaldo Dominguez", "San Martin 5775", "mail2@bb.com", "476768", esc1);
	Alumno alumno3 = new Alumno("Esteban Alvarez", "abajo de un puente", "mail3@cc.com","498327362", esc2);
	Alumno alumno4 = new Alumno("Chavo del 8", "Barril", "chavo@566.com","437687787", esc3);
	Alumno alumno5 = new Alumno("Juan Perez","Su Casa", "mail@aa.com","4328767", esc2);
	Alumno alumno6 = new Alumno("Juan Perez", "Su Casa", "mail@aa.com","6094378437438", esc1);
	
	titular1.addAlumno(alumno1);
	titular2.addAlumno(alumno2);
	titular3.addAlumno(alumno3);
	titular4.addAlumno(alumno4);
	titular1.addAlumno(alumno5);
	titular1.addAlumno(alumno6);
	
	}
	
	
	
	
	
	
}		
		
		
		
		
		
		
		
		
		

