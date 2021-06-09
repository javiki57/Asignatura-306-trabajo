package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.GestionMatricula;
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
	private GestionMatricula mat;
	private Integer curso;
	private Expediente exp;
	private Asignatura a, a1, a2;
	
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Expediente getExp() {
		return exp;
	}

	public void setExp(Expediente exp) {
		this.exp = exp;
	}

	public Asignatura getA() {
		return a;
	}

	public void setA(Asignatura a) {
		this.a = a;
	}

	public Asignatura getA1() {
		return a1;
	}

	public void setA1(Asignatura a1) {
		this.a1 = a1;
	}

	public Asignatura getA2() {
		return a2;
	}

	public void setA2(Asignatura a2) {
		this.a2 = a2;
	}
	
	public void mostrarMatriuclas() throws MatriculaNoEncontradaException {
		mat.mostrarMatriculas(curso);
	}
	
	public void buscarMatricula() throws MatriculaNoEncontradaException {
		mat.buscarMatricula(curso, exp);
	}
	
	public void anyadirAsignatura() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		mat.aniadirAsignatura(a, mat.buscarMatricula(curso, exp));
	}
	
	public void eliminarAsignatura() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException {
		mat.eliminarAsignatura(a, mat.buscarMatricula(curso, exp));
	}
	
	public void intercambiarAsignaturas() throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		/*mat.eliminarAsignatura(a2, m);
		mat.aniadirAsignatura(a1, m);*/
		mat.intercambiarAsignaturas(a1, a2, mat.buscarMatricula(curso, exp));
	}
}
