package es.uma.informatica.sii.jpa.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.jpa.exceptions.AsignaturaExistenteException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.MatriculaNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.*;


@Local
public interface GestionMatricula {

	public void aniadirAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException;
	
	public void eliminarAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException;
	
	void darDeBajaMatricula(Matricula m) throws MatriculaNoEncontradaException;
	
	public void intercambiarAsignaturas(Asignatura actual, Asignatura nueva, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException;

	List<Matricula> mostrarMatriculas(Integer curso) throws MatriculaNoEncontradaException;
	
}
