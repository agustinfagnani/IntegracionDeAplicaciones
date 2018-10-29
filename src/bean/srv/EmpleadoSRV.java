package bean.srv;


import java.util.List;

import bean.dao.HibernateEmpleadoDAO;
import negocio.Empleado; 


public class EmpleadoSRV {
	private static HibernateEmpleadoDAO dao;
	
	static {
		dao = HibernateEmpleadoDAO.getInstancia();
	}
	
	public static void grabarEmpleado(Empleado cli){
		dao.grabarEmpleado(cli);
	}
	
	public static void grabarEmpleados(List<Empleado> empleados){
		dao.grabarEmpleados(empleados);
	}
	
	public static List<Empleado>leerEmpleados()
	{
		return dao.leerEmpleados();
	}
	
}