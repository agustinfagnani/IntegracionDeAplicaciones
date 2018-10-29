package bean;

import java.util.ArrayList;
import java.util.List;


import bean.srv.AlumnoSRV;
import negocio.Alumno;


public class ListAlumnos 
{
	private List<Alumno> alumnos;
	
	public ListAlumnos()
	{
		alumnos= new ArrayList<Alumno>();
		alumnos = AlumnoSRV.leerAlumnos();
		}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public void setAlumnos(List<Alumno> Alumnos) {
		this.alumnos = Alumnos;
	}
	
	public void addCliente(Alumno alumno){
		alumnos.add(alumno);
		AlumnoSRV.grabarAlumno(alumno);
	}
	
	public boolean removeAlumno(Alumno alumn) {
		return alumnos.remove(alumn);
	}
	
	public Alumno getAlumnoPorId(int id){
		for(Alumno u : alumnos){
			if(u.getDni()== id)
				return u;
		}
		return null;
	}
	
	
	
	
	public int size(){
		return alumnos.size();
	}

	public void actualizarBD() 
	{
		AlumnoSRV.grabarAlumnos(alumnos);
		
	}
}
