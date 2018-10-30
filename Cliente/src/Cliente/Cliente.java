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
    
	static TDAManejoDatos sistema;
	Alumno alumno;
	
	public static void main(String[] args)
	{
		try {
//    		IP del Cliente
    			sistema = (TDAManejoDatos)Naming.lookup ("//localhost/GestionAlumnos");
    			sistema.crearAlumno("Gaston", 0, "dir", "mail", "tel", 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }

}
