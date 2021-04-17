package modelo.er.jpa.ejb;

import javax.ejb.Local;
import modelo.er.jpa.proyect.*;

@Local
public interface GestionAlumno {
	
	public void eliminarAlumno(Alumno a);
	
	public void modificarAlumno();
	
	public void mostrarAlumno();
	
}
