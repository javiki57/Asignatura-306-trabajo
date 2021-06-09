package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Named(value="vAlumno")
@RequestScoped
public class vistaAlumno {
	
	private Grupo grupoActual;
	private Grupo grupoNuevo;
	private Titulacion titulacion;
	private Expediente expediente;
	private Alumno a;
	
	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public String hacerEncuesta() {
		return "encuesta.xhtml";
	}
	//grupoactual, gruponuevo, titulacion, expediente
	//metodo que se llame cambiogrupo que coge las variables y llama al ejb para cambiar de grupo
	
	public void cambioGrupo() {
		
	}

	public Grupo getGrupoActual() {
		return grupoActual;
	}

	public void setGrupoActual(Grupo grupoActual) {
		this.grupoActual = grupoActual;
	}

	public Grupo getGrupoNuevo() {
		return grupoNuevo;
	}

	public void setGrupoNuevo(Grupo grupoNuevo) {
		this.grupoNuevo = grupoNuevo;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public Alumno getA() {
		return a;
	}

	public void setA(Alumno a) {
		this.a = a;
	}
	
	
	
}
