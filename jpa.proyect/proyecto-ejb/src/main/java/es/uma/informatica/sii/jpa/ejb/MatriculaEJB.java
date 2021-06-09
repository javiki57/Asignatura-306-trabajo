package es.uma.informatica.sii.jpa.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;

import es.uma.informatica.sii.jpa.exceptions.AsignaturaExistenteException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.MatriculaNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Matricula;


@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="Project")
	private EntityManager em;
	
	@Override
	public void aniadirAsignatura(Asignatura a, Matricula m) throws AsignaturaExistenteException {
		// TODO
		/*Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			throw new AsignaturaNoEncontradaException();
		}*/
		
		//List<Asignatura> lista = m.getListado_Asignaturas();
		
		/*for (Asignatura asignatura : lista) {
			
			if(asignatura.equals(a)) {
				throw new AsignaturaExistenteException();
			}
		}
		
		lista.add(a);
		m.setListado_Asignaturas(lista);*/
		em.merge(m);
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a, Matricula m) {
		// TODO
		/*Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			throw new AsignaturaNoEncontradaException();
		}*/
		
		/*List<Asignatura> lista = m.getListado_Asignaturas();
		lista.remove(a);
		m.setListado_Asignaturas(lista);*/
		em.merge(m);
		
	}
	

	@Override
	public List<Matricula> mostrarMatriculas(Integer curso) throws MatriculaNoEncontradaException {
		// TODO Pedro
		
		Matricula matri = em.find(Matricula.class, curso);
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		return matri.get_matriculas();		
	}
	@Override
	public void intercambiarAsignaturas(Asignatura actual, Asignatura nueva, Matricula m) throws AsignaturaExistenteException {
		//DONE (Rob) 
		eliminarAsignatura(actual, m);
		aniadirAsignatura(nueva, m);
	}

	@Override
	public void darDeBajaMatricula(Matricula m) {
		/*Matricula mat = em.find(Matricula.class, m.getCurso_Academico());
		if(mat==null) {
			throw new MatriculaNoEncontradaException();
		}*/
		m.setEstado(false);
		em.merge(m);	
	}
	
	public Matricula buscarMatricula(Integer curso, Expediente exp) throws MatriculaNoEncontradaException {
		/*Matricula mat = em.find(Matricula.class, curso), aux = null;
		List<Matricula> lista_matriculas = mat.get_matriculas();
		java.util.Iterator<Matricula> i = lista_matriculas.iterator();
		boolean esta = false;
		while((i.hasNext()) && (!esta)) {
			aux = i.next();
			if(aux.getExpediente().equals(exp))
				esta = true;
		}
		if(!esta)
			throw new MatriculaNoEncontradaException();
		
		return aux;*/
		Matricula aux = null;
		List<Matricula> lista_matriculas = exp.getMatriculas();
		java.util.Iterator<Matricula> i = lista_matriculas.iterator();
		boolean esta = false;
		while((i.hasNext()) && (!esta)) {
			aux = i.next();
			if(aux.getCurso_Academico().equals(curso))
				esta = true;
		}
		if(!esta)
			throw new MatriculaNoEncontradaException();
		
		return aux;
	}

}
