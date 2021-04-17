package modelo.er.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.proyect.Alumno;

@Stateless
public class AlumnoEJB implements GestionAlumno{

	@Override
	public void eliminarAlumno(Alumno a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAlumno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarAlumno() {
		// TODO Auto-generated method stub
		
	}

}
