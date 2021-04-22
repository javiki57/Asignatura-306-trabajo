package modelo.er.jpa.ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.er.jpa.exceptions.AsignaturaExistenteException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.MatriculaNoEncontradaException;
import modelo.er.jpa.proyect.*;


@Local
public interface GestionMatricula {

	public void aniadirAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException;
	
	public void eliminarAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException;
	
	public List<Matricula> mostrarMatriculas(Matricula m) throws MatriculaNoEncontradaException;
	public void asignarGrupoNuevoIngreso();
	public void asignarGrupoAntiguo();
	public void darDeBajaMatricula();
	public List<Matricula> mostrarMatriculas();
	void asignarGrupoNuevoIngreso(Grupo g, Alumno a);
	void asignarGrupoNuevoIngreso(Expediente e, Alumno a, Matricula m);
	void asignarGrupoNuevoIngreso(Expediente e, Alumno a, String turnoPref, Matricula m);
	
}
