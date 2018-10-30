package Servidor;
// para publicar alumnos
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import Repositorio.TDAManejoDatos;



public class Server {
    
	TDAManejoDatos objetoRemoto;
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	public Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		LocateRegistry.createRegistry(1099);	
            TDAManejoDatos gestionAlumnos = new GestionAlumnos();
//          Nombre publico para trabajar
            Naming.rebind ("//localhost/GestionAlumnos", gestionAlumnos);
            System.out.println("Fijado en //localhost/GestionAlumnos");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
