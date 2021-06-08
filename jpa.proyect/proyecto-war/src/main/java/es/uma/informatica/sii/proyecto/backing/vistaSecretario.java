package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="vSecretario")
@RequestScoped
public class vistaSecretario {
	
	public String verGrupos() {
		return "grupos.xhtml";
	}
	
	public String verAlumnos() {
		return "alumnos.xhtml";
	}
	
	public String verMatriculas() {
		return "matricula.xhtml";
	}
	
	public String verTitulaiones() {
		return "titulaciones.xhtml";
	}
	
}
