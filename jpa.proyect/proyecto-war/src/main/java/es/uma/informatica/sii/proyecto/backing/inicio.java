package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="inicio")
@RequestScoped
public class inicio {

	public String conectarAlumno() {
		return "vistaAlumno.xhtml";
	}
	
	public String conectarSecretaria() {
		return "vistaSecretario.xhtml";
	}
}
