package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.proyect.Grupo;

@Named(value="encuesta")
@RequestScoped
public class EncuestaBB {
	//EncuestaEJB encEJB = new EncuestaEJB();
	
	private Grupo primero, segundo, tercero, cuarto;
	
	public void enviarEncuesta() {
		
	}
	
	
}
