package es.uma.informatica.sii.proyecto.backing;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.EncuestaEJB;
import es.uma.informatica.sii.jpa.ejb.GestionEncuesta;
import es.uma.informatica.sii.jpa.exceptions.EncuestaExistenteException;
import es.uma.informatica.sii.jpa.proyect.Encuesta;
import es.uma.informatica.sii.jpa.proyect.Grupo;

@Named(value="encuesta")
@RequestScoped
public class EncuestaBB implements Serializable{
	
	@Inject
	private GestionEncuesta encEJB;
	
	//private Grupo primero, segundo, tercero, cuarto;
	private Encuesta encuesta;
	
	public void enviarEncuesta() throws EncuestaExistenteException {
		encEJB.guardarEncuesta(encuesta);
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	
	
}
