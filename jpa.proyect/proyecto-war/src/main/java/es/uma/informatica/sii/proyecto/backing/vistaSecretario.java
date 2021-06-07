package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="vSecretario")
@RequestScoped
public class vistaSecretario {
	
	public String verGrupos() {
		return "Grupos.xhtml";
	}
	
	public String verAlumnos() {
		return "Alumnos.xhtml";
	}
	
	public String verMatriculas() {
		return "Matriculas.xhtml";
	}
}
