package es.uma.informatica.sii.proyecto.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.AlumnoEJB;
import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;

//RUD ALUMNOS, mostrar alumnos(buscar alumno), actualizar alumno y borrrar alumno.
//Parametros tal cual , despues los cambiamos.


@Named(value="alumno")
@RequestScoped
public class AlumnoBB {
	
	@Inject
	private AlumnoEJB alEJB;
	private List<Alumno> alumnos;
	private Alumno a;
	
	//Entiendo que mostrar y buscar es lo mismo.
	public String mostrarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno alumno = alEJB.mostrarAlumno(a.getId());	 
		return alumno.getNombre_Completo()+alumno.getDNI()+alumno.getEmail_Institucional();
	
	}
	public void actualizarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		alEJB.actualizarAlumno(a);
	
	}
	public void borrarAlumno(Alumno a) throws AlumnoNoEncontradoException {		
		alEJB.eliminarAlumno(a);	
		
	}

}
