package modelo.er.jpa.ejb;

import javax.ejb.Local;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.proyect.*;

@Local
public interface GestionAlumno {
	
	public void eliminarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public void actualizarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public Alumno mostrarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
}
