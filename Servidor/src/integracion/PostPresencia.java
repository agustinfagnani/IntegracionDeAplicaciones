package integracion;
import java.io.FileInputStream;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import interfaces.CargaEmpleado;
import exception.ErrorConeccionPresenciaException;
import negocio.Empleado;

public class PostPresencia {


	private CargaEmpleado carga;
	private String miCuit;
	
	
	public boolean getStub() {  
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("direcciones.properties");

			// load a properties file
			prop.load(input);
		}
		catch(Exception e){
			
		}
			
		String IP = prop.getProperty("ipPresentismo");
		miCuit = prop.getProperty("miCuit");
		
		try {
			carga = (CargaEmpleado)Naming.lookup ("//" + IP + "/CargaEmpleado");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public PostPresencia(Empleado em) throws ErrorConeccionPresenciaException{
		if(getStub()) 
		{
			try {
				carga.cargaEmpleado(miCuit, "" + em.getLegajo(), em.getNombre(), em.getApellido(), em.getMail(), "" + Integer.toString(em.getDNI()), em.getTelefono(), "mensual", 160);
			} catch (RemoteException e) {
				throw new ErrorConeccionPresenciaException();
			}    			
		} 
	}

}
