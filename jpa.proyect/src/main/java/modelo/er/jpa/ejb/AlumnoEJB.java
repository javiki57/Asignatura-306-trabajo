package modelo.er.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.proyect.Alumno;

@Stateless
public class AlumnoEJB implements GestionAlumno{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void eliminarAlumno(Alumno a) {
		// TODO 
		Alumno al = em.find(Alumno.class, a.getId());
		
		if(al == null) {
			//hacer excepcion.
		}
		
		List<Alumno> lista = al.getAlumnos();
		lista.remove(a.getId());
		al.setAlumnos(lista);
		em.persist(al);
	}

	@Override
	public void actualizarAlumno(Alumno a) {
		// TODO
		Alumno al = em.find(Alumno.class, a.getId());
		
		if(al == null) {
			//hacer excepcion.
		}
		
		al.setEmail_Personal(a.getEmail_Personal());
		al.setCodigo_Postal_Notificacion(a.getCodigo_Postal_Notificacion());
		al.setTelefono(a.getTelefono());
		al.setMovil(a.getMovil());
		al.setDireccion_Notificacion(a.getDireccion_Notificacion());
		em.persist(al);
		
	}

	@Override
	public Alumno mostrarAlumno(Alumno a) {
		// TODO 
		List<Alumno> lista = a.getAlumnos();
		Alumno al = null;
		
		for (Alumno alumno : lista) {
			
			if(alumno.getId() == a.getId()) {
				al = alumno;
			}
		}
		
		return al;
		
	}

}
