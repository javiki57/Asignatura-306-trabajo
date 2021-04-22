package modelo.er.jpa.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.exceptions.AsignaturaExistenteException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.MatriculaNoEncontradaException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Asignatura;
import modelo.er.jpa.proyect.Expediente;
import modelo.er.jpa.proyect.Grupo;
import modelo.er.jpa.proyect.Matricula;


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
		em.persist(matri);
		
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
		em.persist(matri);
		
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
	public void asignarGrupoNuevoIngreso(Expediente e, Alumno a,String turnoPref, Matricula m) {
		
		Expediente expe = em.find(Expediente.class, e.getNum_Expediente());
		
		Matricula mat = em.find(Matricula.class, m.getCurso_Academico());
		
		Alumno al = em.find(Alumno.class, a.getId());
		
		if(al==null) {
			//hacer excepcion
		}
		Grupo gr = em.find(Grupo.class, g.getId());
		
		if(gr==null) {
			
			//hacer excepcion
		}
		
		List<Matricula> matriculas = expe.getMatriculas();
		
		if(!matriculas.contains(mat)){
			//Excepcion si esta la matricula
			
		}
		
		List<Alumno> listaAlumnos= al.getAlumnos();
		
		listaAlumnos.add(a);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public void asignarGrupoAntiguo() {
		// TODO 
		
	}

	@Override
	public void darDeBajaMatricula() {
		// TODO 
		
	}

}
