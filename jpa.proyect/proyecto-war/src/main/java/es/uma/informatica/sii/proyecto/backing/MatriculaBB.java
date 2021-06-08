package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

	@Inject
	private MatriculaEJB mat;
	private Integer curso;
	private Expediente exp;
	private Asignatura a, a1, a2;
	private Matricula m;
	
	public void mostrarMatriuclas() throws MatriculaNoEncontradaException {
		mat.mostrarMatriculas(curso);
	}
	
	public void buscarMatricula() throws MatriculaNoEncontradaException {
		mat.buscarMatricula(curso, exp);
	}
	
	public void anyadirAsignatura() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		mat.aniadirAsignatura(a, m);
	}
	
	public void eliminarAsignatura() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException {
		mat.eliminarAsignatura(a, m);
	}
	
	public void intercambiarAsignaturas() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		/*mat.eliminarAsignatura(a2, m);
		mat.aniadirAsignatura(a1, m);*/
		mat.intercambiarAsignaturas(a1, a2, m);
	}
}
