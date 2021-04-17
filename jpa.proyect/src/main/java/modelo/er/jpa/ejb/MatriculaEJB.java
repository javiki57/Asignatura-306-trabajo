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
	public void aniadirAsignatura(Asignatura a) {
		// TODO
		
	}

	@Override
	public void eliminarAsignatura() {
		// TODO
		
	}

	@Override
	public List<Matricula> mostrarMatriculas() {
		
		
		return null;		
	}

}
