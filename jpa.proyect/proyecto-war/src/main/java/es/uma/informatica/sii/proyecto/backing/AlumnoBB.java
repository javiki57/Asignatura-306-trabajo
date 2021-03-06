package es.uma.informatica.sii.proyecto.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.AlumnoEJB;
import es.uma.informatica.sii.jpa.ejb.GestionAlumno;
import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;

//RUD ALUMNOS, mostrar alumnos(buscar alumno), actualizar alumno y borrrar alumno.
//Parametros tal cual , despues los cambiamos.


@Named(value="alumnoBB")
@RequestScoped
public class AlumnoBB {
	
	@Inject
	private GestionAlumno alEJB;
	private Alumno a;
	private List<Alumno> alumnos;
	
	public AlumnoBB(){
		
	}
	
	public Alumno getA() {
		return a;
	}
	public void setA(Alumno a) {
		this.a = a;
	}
	
	public List<Alumno> getAlumnos() {
		return alEJB.mostrarTodosLosAlumnos();
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public String gestionar() {
		return "gestionarAlumnos.xhtml";
	}
	//Entiendo que mostrar y buscar es lo mismo.
	public String mostrarAlumno() throws AlumnoNoEncontradoException {
		Alumno alumno = alEJB.mostrarAlumno(a.getId());	 
		return alumno.getNombre_Completo()+alumno.getDNI()+alumno.getEmail_Institucional();
	
	}
	public void actualizarAlumno() throws AlumnoNoEncontradoException {
		alEJB.actualizarAlumno(a);
	
	}
	public void borrarAlumno() throws AlumnoNoEncontradoException {		
		alEJB.eliminarAlumno(a);	
		
	}

}
