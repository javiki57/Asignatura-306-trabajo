package modelo.er.jpa.ejb;

import javax.ejb.Local;
import modelo.er.jpa.proyect.*;

@Local
public interface GestionAlumno {
	
	public void eliminarAlumno(Alumno a);
	
	public void actualizarAlumno(Alumno a);
	
	public void mostrarAlumno(Alumno a);
	
}
