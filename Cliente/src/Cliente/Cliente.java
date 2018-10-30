package Cliente;

import java.awt.EventQueue;
import java.rmi.Naming;
import Repositorio.TDAManejoDatos;
import swing.Menu;


public class Cliente {
    
	static TDAManejoDatos sistema;
	static String IP = "192.168.156.119";
	
	public static void main(String[] args)
	{
		try {
    			sistema = (TDAManejoDatos)Naming.lookup ("//" + IP + "/GestionAlumnos");
			inicializarVentana();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	public static void inicializarVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TDAManejoDatos getInstance() {
		return sistema;
	}

}
