package modelo.er.jpa.ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.proyect.Asignatura;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@Override
	public void aniadirAsignatura(Asignatura a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAsignatura() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarMatriculas() {
		// TODO Auto-generated method stub
		
	}

}
