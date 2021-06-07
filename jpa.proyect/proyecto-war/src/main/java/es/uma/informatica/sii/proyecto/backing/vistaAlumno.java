package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Named(value="vAlumno")
@RequestScoped
public class vistaAlumno {
	
	private Grupo grupoActual;
	private Grupo grupoNuevo;
	private Titulacion titulacion;
	
	public String hacerEncuesta() {
		return "encuesta.xhtml";
	}
	//grupoactual, gruponuevo, titulacion, expediente
	//metodo que se llame cambiogrupo que coge las variables y llama al ejb para cambiar de grupo
	
	public void cambioGrupo() {
		
	}
	
	
	
}
