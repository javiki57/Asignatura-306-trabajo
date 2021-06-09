package es.uma.informatica.sii.jpa.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Matricula;

@Stateless
public class AlumnoEJB implements GestionAlumno{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void eliminarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// DONE 
		
		em.merge(a);
		em.remove(a);
	}

	@Override
	public void actualizarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		// DONE 
	
		em.merge(a);
		
	}

	@Override
	public Alumno mostrarAlumno(Integer pk) throws AlumnoNoEncontradoException {
		// DONE 
		Alumno alum = em.find(Alumno.class, pk);
		
		if(alum == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		return alum;
		
	}
	
	public List<Alumno> mostrarAlumnosNuevos(Integer a) throws AlumnoNoEncontradoException {
		//Query q = em.createQuery("select a from Alumno a where a.expediente")
			//	("SELECT j FROM Joven j WHERE j.idJoven <> -1");
		// DONE (Rob)
		Alumno al = em.find(Alumno.class, a);//buscamos el alumno
		
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
		//Conseguimos la lista de alumnos existentes e inicializamos la lista de los nuevos alumnos
		//List<Alumno> alumnos = al.getAlumnos();
		List<Alumno> nuevosAlumnos = new ArrayList<>();
		
		/*for(Alumno aux : alumnos) {
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
		}*/
		return nuevosAlumnos;	
	}
	@Override
	public List<Alumno> buscarMatriculas(Alumno a) throws AlumnoNoEncontradoException {
		// TODO Auto-generated method stub
		Alumno al = em.find(Alumno.class, a.getId());
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		
	//	List<Alumno> lista = al.getAlumnos();
		List<Alumno> matriculados = new ArrayList();
	/*	for(Alumno alumno: lista) {
			List<Expediente> expedientes = alumno.getExpediente();
			int i=0;
			while(!expedientes.get(i).getActiva() && i<expedientes.size()) {
				i++;
			}
			if(i<expedientes.size()) {
				Expediente exp = expedientes.get(i);
				List<Matricula> matriculas = exp.getMatriculas();
				int j=0;
				while(!matriculas.get(j).getEstado() && j<matriculas.size()) {
					j++;
				}
				if(j<matriculas.size())	matriculados.add(alumno);
			}
		}*/
		
		return matriculados;
	}


	
	
	

}
