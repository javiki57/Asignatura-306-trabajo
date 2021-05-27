package es.uma.informatica.sii.jpa.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void aniadirAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		// TODO
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			throw new AsignaturaNoEncontradaException();
		}
		
		List<Asignatura> lista = matri.getListado_Asignaturas();
		
		for (Asignatura asignatura : lista) {
			
			if(asignatura.equals(a)) {
				throw new AsignaturaExistenteException();
			}
		}
		
		lista.add(a);
		matri.setListado_Asignaturas(lista);
		em.merge(matri);
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException{
		// TODO
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			throw new AsignaturaNoEncontradaException();
		}
		
		List<Asignatura> lista = matri.getListado_Asignaturas();
		lista.remove(a);
		matri.setListado_Asignaturas(lista);
		em.merge(matri);
		
	}

	@Override
	public List<Matricula> mostrarMatriculas(Matricula m) throws MatriculaNoEncontradaException {
		// TODO Pedro
		
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			throw new MatriculaNoEncontradaException();
		}
		
		return null;		
	}
	@Override
	public void intercambiarAsignaturas(Asignatura actual, Asignatura nueva, Matricula m) throws AsignaturaNoEncontradaException, MatriculaNoEncontradaException, AsignaturaExistenteException {
		//DONE (Rob) SIN PROBAR
		eliminarAsignatura(actual, m);
		aniadirAsignatura(nueva, m);
	}

	@Override
	public void darDeBajaMatricula(Matricula m) throws MatriculaNoEncontradaException {
		Matricula mat = em.find(Matricula.class, m.getCurso_Academico());
		if(mat==null) {
			throw new MatriculaNoEncontradaException();
		}
		m.setEstado(false);
		em.merge(m);	
	}

}
