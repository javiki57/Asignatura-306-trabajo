package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.MatriculaEJB;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaExistenteException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.MatriculaNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Matricula;

@Named(value="matricula")
@RequestScoped
public class MatriculaBB {

	private MatriculaEJB mat;
	
	public void mostrarMatriuclas(Integer curso) throws MatriculaNoEncontradaException {
		mat.mostrarMatriculas(curso);
	}
	
	public void buscarMatricula(Integer curso, Expediente exp) throws MatriculaNoEncontradaException {
		mat.buscarMatricula(curso, exp);
	}
	
	public void anyadirAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		mat.aniadirAsignatura(a, m);
	}
	
	public void eliminarAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException {
		mat.eliminarAsignatura(a, m);
	}
	
	public void intercambiarAsignaturas(Asignatura a1, Asignatura a2, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		mat.eliminarAsignatura(a2, m);
		mat.aniadirAsignatura(a1, m);
	}
}
