package Cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;

import interfaces.CargaEmpleado;

public class ClienteCargaEmpleado {
    
	CargaEmpleado carga;
	
	public static void main(String[] args)
	{
		new ClienteCargaEmpleado();
	}
	
    public boolean getStub() {
    	
    	try {
			carga = (CargaEmpleado)Naming.lookup ("//192.168.157.152/CargaEmpleado");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public ClienteCargaEmpleado(){
    	if(getStub()) 
    	{
    		try {
				carga.cargaEmpleado("40365856861", "1111", "Homero", "Sipmson", "mail", "35359186", "test");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    			
    	} 
    }

}
