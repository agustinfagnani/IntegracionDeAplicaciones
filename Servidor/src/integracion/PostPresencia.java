package integracion;
import java.rmi.Naming;
import java.rmi.RemoteException;
import interfaces.CargaEmpleado;
import exception.ErrorConeccionPresenciaException;
import negocio.Empleado;

public class PostPresencia {

	private String IP = "192.168.215.224";
	private final String miCuit = "30715087738";

	CargaEmpleado carga;

	public boolean getStub() {    	
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
