package modelo.er.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.proyect.Alumno;

@Stateless
public class AlumnoEJB implements GestionAlumno{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void eliminarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// TODO 
		Alumno al = em.find(Alumno.class, a.getId());
		
		if(al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		List<Alumno> lista = al.getAlumnos();
		lista.remove(a.getId());
		al.setAlumnos(lista);
		em.persist(al);
	}

	@Override
	public void actualizarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// TODO
		Alumno al = em.find(Alumno.class, a.getId());
		
		if(al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		al.setEmail_Personal(a.getEmail_Personal());
		al.setCodigo_Postal_Notificacion(a.getCodigo_Postal_Notificacion());
		al.setTelefono(a.getTelefono());
		al.setMovil(a.getMovil());
		al.setDireccion_Notificacion(a.getDireccion_Notificacion());
		em.persist(al);
		
	}

	@Override
	public Alumno mostrarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// TODO 
		Alumno alum = em.find(Alumno.class, a.getId());
		
		if(alum == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		List<Alumno> lista = alum.getAlumnos();
		Alumno al = null;
		
		for (Alumno alumno : lista) {
			
			if(alumno.getId() == a.getId()) {
				al = alumno;
			}
		}
		
		return al;
		
	}

}
