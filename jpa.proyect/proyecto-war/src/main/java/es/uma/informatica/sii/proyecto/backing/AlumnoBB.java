package es.uma.informatica.sii.proyecto.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.AlumnoEJB;
import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;

//RUD ALUMNOS, mostrar alumnos(buscar alumno), actualizar alumno y borrrar alumno.
//Parametros tal cual , despues los cambiamos.


@Named(value="alumno")
@RequestScoped
public class AlumnoBB {

	private AlumnoEJB alEJB;
	private List<Alumno> alumnos;
	
	//Entiendo que mostrar y buscar es lo mismo.
	public String mostrarAlumno(Alumno a1) throws AlumnoNoEncontradoException {
		Alumno alumno = alEJB.mostrarAlumno(a1);	 
		return alumno.getNombre_Completo()+alumno.getDNI()+alumno.getEmail_Institucional();
	
	}
	public String actualizarAlumno(Alumno a1, Alumno a2) throws AlumnoNoEncontradoException {
		alEJB.actualizarAlumno(a1,a2);
		return "Alumno: "+a1.getNombre_Completo();
	}
	public String borrarAlumno(Alumno a1) throws AlumnoNoEncontradoException {		
		alEJB.eliminarAlumno(a1);	
		return "Alumno: " + a1.getNombre_Completo();
	}

}
