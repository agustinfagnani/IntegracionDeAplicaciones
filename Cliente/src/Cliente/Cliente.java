package Cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import Repositorio.TDAManejoDatos;
import negocio.Alumno;
import negocio.Escolaridad;
import negocio.Titular;


public class Cliente {
    
	TDAManejoDatos manejoAlumnos;
	Alumno alumno;
	
	public static void main(String[] args)
	{
		new Cliente();
	}
	
    public boolean getStub() {
    	
    	try {
//    		IP del Cliente
			manejoAlumnos = (TDAManejoDatos)Naming.lookup ("//localhost/GestionAlumnos");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public Cliente(){
    	if(getStub()) 
    	{
    		try {
//    			/*Agrego un alumno*/
//    			Titular t = new Titular("Titular1", 123, "direccion1", "mail", "telefono1");
//    			Escolaridad esc1 = new Escolaridad("Turno mañana", 123);
//    			System.out.println("\nAgrego un alumno");
//    			Alumno alumno = new Alumno("Alumno1", t, "dire1", "mail", "telefono", esc1);	
//    			manejoAlumnos.envioAlumno(alumno);
    			
    			/*Busco por  número de alumno*/
//    			alumno = manejoAlumnos.obtengoAlumno(1);
//    			System.out.println(alumno.getNombre());
    			/*Listo todos los alumnos*/
    			System.out.println("\nListo Todos los Alumnos");
    			ArrayList<Alumno> alumnos = manejoAlumnos.obtengoAlumnos();
//    			for(Iterator<Alumno> i=alumnos.iterator();i.hasNext();)
//    			{
//    				System.out.println(i.next().toString());
//    			}


    			for(Alumno a: alumnos) {
    				System.out.println(a.toString());
    			}
    			
    			/*Listo todos los alumnos con el agregado*/
    			System.out.println("\nListo Todos los Alumnos");
    			alumnos = manejoAlumnos.obtengoAlumnos();
    			for(Iterator<Alumno> i=alumnos.iterator();i.hasNext();)
    			{
    				System.out.println(i.next().toString());
    			}
    			/*Obtengo la cantidad de alumnos*/
    			System.out.println("\nCantidad de Alumnos " + manejoAlumnos.cantidadAlumnos());
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} 
    }

}
