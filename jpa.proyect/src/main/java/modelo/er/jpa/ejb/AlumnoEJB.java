package modelo.er.jpa.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Expediente;

@Stateless
public class AlumnoEJB implements GestionAlumno{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void eliminarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// DONE (SIN PROBAR)
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
		// DONE (SIN PROBAR)
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
		// DONE (SIN PROBAR) 
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
	
	public List<Alumno> mostrarAlumnosNuevos(Alumno a) throws AlumnoNoEncontradoException {
		// DOING 
		Alumno al = em.find(Alumno.class, a.getId());
		
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		List<Alumno> alumnos = al.getAlumnos();
		List<Alumno> nuevosAlumnos = new ArrayList<>();
		for(Alumno aux : alumnos) {
			int i=0;
			boolean encontrado = false;
			while((i<aux.getExpediente().size()) && !encontrado) {
				Expediente exp = (Expediente) aux.getExpediente().get(i);
				if(exp.getActiva()) {
					encontrado = true;
					//Otra forma de hacer esto seria hacer un bucle para buscar las matriculas hasta ver si la matricula 
					//esta activa y es de nuevo ingreso
					if((exp.getMatricula().size()==1) && exp.getMatricula().get(0).getNuevo_Ingreso()) {
						nuevosAlumnos.add(aux);
					}
				}
					
				i=i+1;
			}
		}
		
		return nuevosAlumnos;
		
	}
	

}
