package modelo.er.jpa.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.proyect.Asignatura;
import modelo.er.jpa.proyect.Matricula;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="Project")
	private EntityManager em;
	
	@Override
	public void aniadirAsignatura(Asignatura a, Matricula m) {
		// TODO
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			//Añadir excepcion.
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			//Añadir excepcion
		}
		
		List<Asignatura> lista = matri.getListado_Asignaturas();
		
		for (Asignatura asignatura : lista) {
			
			if(asignatura.equals(a)) {
				//Crear excepcion
			}
		}
		
		lista.add(a);
		matri.setListado_Asignaturas(lista);
		em.persist(matri);
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a, Matricula m) {
		// TODO
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			//Añadir excepcion.
		}
		
		Asignatura asi = em.find(Asignatura.class, a.getCódigo());
		
		if(asi == null) {
			//Añadir excepcion
		}
		
		List<Asignatura> lista = matri.getListado_Asignaturas();
		lista.remove(a);
		matri.setListado_Asignaturas(lista);
		em.persist(matri);
		
	}

	@Override
	public List<Matricula> mostrarMatriculas(Matricula m) {
		// TODO
		
		Matricula matri = em.find(Matricula.class, m.getCurso_Academico());
		
		if(matri == null) {
			//Añadir excepcion.
		}
		
		
		
		return null;		
	}

}
