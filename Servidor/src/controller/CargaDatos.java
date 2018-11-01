package controller;

import bean.dao.HibernateAdicionalDAO;
import bean.dao.HibernateAlumnoDAO;
import bean.dao.HibernateEmpleadoDAO;
import bean.dao.HibernateEscolaridadDAO;
import bean.dao.HibernateTitularDAO;
import hbt.HibernateUtil;
import negocio.Adicional;
import negocio.Alumno;
import negocio.Credito;
import negocio.Deposito;
import negocio.Empleado;
import negocio.Escolaridad;
import negocio.Titular;

public class CargaDatos {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
	
	
	
	{
		
		//CARGA ESCOLARIDADES
	
		Escolaridad esc1 = new Escolaridad("Turno maniana", 1500);
		HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc1);
		Escolaridad esc2 = new Escolaridad("Turno tarde", 1000);
		HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc2);
		Escolaridad esc3 = new Escolaridad("Doble Turno", 2000);
		HibernateEscolaridadDAO.getInstancia().grabarEscolaridad(esc3);

		
		//CARGA ALUMNOS
		
		Alumno alumno1 = new Alumno("Juan Perez", "Su Casa", "mail@aa.com","4256575", esc1);
		Alumno alumno2 = new Alumno("Osvaldo Dominguez", "San Martin 5775", "mail2@bb.com", "476768", esc1);
		Alumno alumno3 = new Alumno("Esteban Alvarez", "abajo de un puente", "mail3@cc.com","498327362", esc2);
		Alumno alumno4 = new Alumno("Chavo del 8", "Barril", "chavo@566.com","437687787", esc3);
		Alumno alumno5 = new Alumno("Jon Snow", "En el Norte", "jon@aa.com","4328767", esc2);
		Alumno alumno6 = new Alumno("Juliana Gonzalez", "Su Casa", "ju@aa.com","60943665437438", esc1);
		Alumno alumno7 = new Alumno("Macarena Fernandez", "Su Casa", "ma@aa.com","6094678437438", esc1);
		
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno1);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno2);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno3);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno4);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno5);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno6);
		HibernateAlumnoDAO.getInstancia().grabarAlumno(alumno7);
		
		
		//CARGA TITULARES
		
		Credito tipo1 = new Credito("1234567812345678", 567);
		Deposito tipo2 = new Deposito("1234567891234567891234");
		Credito tipo3 = new Credito("9876543298765432", 111);
		Credito tipo4 = new Credito("9999999999999999", 998);
		Deposito tipo5 = new Deposito("4444444444444444444444");
		Deposito tipo6 = new Deposito("5555555555555555555555");
	
		Titular titular1 = new Titular("Alfredo Fernandez", 123, "San Martin 234", "aa@yahoo.com", "1111", tipo1);
		Titular titular2 = new Titular("Ricardo Benitez", 567, "Sarmiento 234", "aa@gmail.com", "333", tipo2);
		Titular titular3 = new Titular("Roberto Rodriguez", 345, "Belgrano 234", "aa@hotmail.com", "2222", tipo3);
		Titular titular4 = new Titular("Leonardo DiCaprio", 444, "Av Libertador 1", "leo@gmail.com", "12347688", tipo4);
		Titular titular5 = new Titular("Pipa Benedetto", 555, "San Martin 111", "pipa@yahoo.com", "76785445", tipo5);
		Titular titular6 = new Titular("Roger Federer", 666, "Lugones 453", "roger@yahoo.com", "9856778", tipo6);
	
		titular1.addAlumno(alumno1);
		titular1.addAlumno(alumno2);
		titular2.addAlumno(alumno3);
		titular3.addAlumno(alumno4);
		titular4.addAlumno(alumno5);
		titular5.addAlumno(alumno6);
		titular6.addAlumno(alumno7);
		
		HibernateTitularDAO.getInstancia().grabarTitular(titular1);
		HibernateTitularDAO.getInstancia().grabarTitular(titular2);
		HibernateTitularDAO.getInstancia().grabarTitular(titular3);
		HibernateTitularDAO.getInstancia().grabarTitular(titular4);
		HibernateTitularDAO.getInstancia().grabarTitular(titular5);
		HibernateTitularDAO.getInstancia().grabarTitular(titular6);
	
			
		//CARGA EMPLEADOS
		
		Empleado empleado1 = new Empleado(12875398, "Profesor", "Albert", "Einstein", "Av 9 de Julio 12", "asd@asd.com", "4556",20000, "1234567890123456789012");
		Empleado empleado2 = new Empleado(33435678, "Profesor", "Profesor", "Jirafales", "Av 9 de Julio 13", "asd2@asd.com", "5555",25000,"098765432109876543276");
		Empleado empleado3 = new Empleado(30987777, "Kiosquero", "Cacho", "Fernandez", "Av 9 de Julio 14", "asd3@asd.com", "6666",50000,"9999999999999999999999");
		Empleado empleado4 = new Empleado(36587777, "Cocinero", "Richard", "Fernandez", "Av 9 de Julio 15", "asd4@asd.com", "6666",50000,"9923999999999999999999");
		Empleado empleado5 = new Empleado(33498777, "Profesor", "Isaac", "Newton", "Av 9 de Julio 16", "asd5@asd.com", "6666",500,"9999999999976999999999");
		Empleado empleado6 = new Empleado(31254777, "Profesor", "Bruno", "Diaz", "Av 9 de Julio 17", "asd6@asd.com", "6666",53400,"9999999999934999999999");
		Empleado empleado7 = new Empleado(39856777, "Profesor", "Juan Roman", "Riquelme", "Av 9 de Julio 18", "asd7@asd.com", "6666",52300,"1299999999999999999999");
		
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado1);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado2);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado3);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado4);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado5);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado6);
		HibernateEmpleadoDAO.getInstancia().grabarEmpleado(empleado7);
		
		
		//CARGA ADICONALES
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
	
	
	
	
	}
	
	}
	
	
}
		
		
		
		

