package modelo.er.jpa.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Expediente;
import modelo.er.jpa.proyect.Matricula;

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
		// DONE (SIN PROBRAR) (Rob)
		Alumno al = em.find(Alumno.class, a.getId());//buscamos el alumno
		
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		//Conseguimos la lista de alumnos existentes e inicializamos la lista de los nuevos alumnos
		List<Alumno> alumnos = al.getAlumnos();
		List<Alumno> nuevosAlumnos = new ArrayList<>();
		
		for(Alumno aux : alumnos) {
			int i=0;
			boolean encontrado = false;//expediente activo encontrado o no 
			
			//recorremos la lista de expedientes asociados al alumno
			while((i<aux.getExpediente().size()) && !encontrado) {
				Expediente exp = (Expediente) aux.getExpediente().get(i);
				
				if(exp.getActiva()) {//si el expediente esta activo
					encontrado = true;
					
					//Otra forma de hacer esto seria hacer un bucle para buscar las matriculas hasta ver si la matricula 
					//esta activa y es de nuevo ingreso
					if((exp.getMatriculas().size()==1) && exp.getMatriculas().get(0).getNuevo_Ingreso()) {
						nuevosAlumnos.add(aux); //añadimos el alumno con nueva matricula activa
					}
				}
					
				i=i+1;
			}
		}
		
		return nuevosAlumnos;
		
	}

	@Override
	public List<Alumno> buscarMatriculas(Alumno a) throws AlumnoNoEncontradoException {
		// TODO Auto-generated method stub
		//Sin probar
		Alumno al = em.find(Alumno.class, a.getId());
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		List<Alumno> lista = al.getAlumnos();
		List<Alumno> matriculados = new ArrayList();
		for(Alumno alumno: lista) {
			List<Expediente> expedientes = alumno.getExpediente();
			int i=0;
			while(!expedientes.get(i).getActiva()) {
				i++;
			}
			if(i<expedientes.size()) {
				Expediente exp = expedientes.get(i);
				List<Matricula> matriculas = exp.getMatriculas();
				int j=0;
				while(!matriculas.get(j).getEstado()) {
					j++;
				}
				if(j<matriculas.size())	matriculados.add(alumno);
			}
		}
		
		
		
		return matriculados;
	}
	
	
	

}
