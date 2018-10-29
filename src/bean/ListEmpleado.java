package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.EmpleadoSRV;
import negocio.Empleado;




public class ListEmpleado 
{
	private List<Empleado> empleados;
	
	public ListEmpleado()
	{
		empleados= new ArrayList<Empleado>();
		empleados = EmpleadoSRV.leerEmpleados();
		}

	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> Empleados) {
		this.empleados = Empleados;
	}
	
	public void addEmpleado(Empleado emp){
		empleados.add(emp);
		EmpleadoSRV.grabarEmpleado(emp);
	}
	
	public boolean removeEmpleado(Empleado emp) {
		return empleados.remove(emp);
	}
	
	public Empleado getEmpleadoPorId(int id){
//		for(Empleado u : empleados){
//			if(u.getDni()== id)
//				return u;
//		}
		return null;
	}
	
	
	
	
	public int size(){
		return empleados.size();
	}

	public void actualizarBD() 
	{
		EmpleadoSRV.grabarEmpleados(empleados);
		
	}
}
