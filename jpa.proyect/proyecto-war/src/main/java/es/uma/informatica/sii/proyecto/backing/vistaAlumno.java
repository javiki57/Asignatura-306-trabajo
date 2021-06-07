package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="vAlumno")
@RequestScoped
public class vistaAlumno {
	
	public String hacerEncuesta() {
		return "encuesta.xhtml";
	}
	
	
	
}
