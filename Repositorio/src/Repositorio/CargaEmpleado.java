package Repositorio;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface CargaEmpleado extends Remote {

	//metodos con DTOs
	public void cargaEmpleado(String CUITEmpresa, String legajo,String nombre, String apellido, String mail, String dni, String telefono) throws RemoteException;

}