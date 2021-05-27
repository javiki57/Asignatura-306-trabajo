package es.uma.informatica.sii.jpa.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.*;

@Local
public interface GestionAlumno {
	
	public void eliminarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public void actualizarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public Alumno mostrarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public List<Alumno> mostrarAlumnosNuevos(Alumno a) throws AlumnoNoEncontradoException;
	
	public List<Alumno> buscarMatriculas(Alumno a) throws AlumnoNoEncontradoException;
	
}
