package Servidor;
// para publicar alumnos
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import Repositorio.TDAManejoDatos;
import controller.SistemaEscuela;
import negocio.Adicional;



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
            TDAManejoDatos gestionAlumnos = new SistemaEscuela();
            Naming.rebind ("//localhost/GestionAlumnos", gestionAlumnos);
            System.out.println("Fijado en //localhost/GestionAlumnos");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
