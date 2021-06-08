package es.uma.informatica.sii.jpa.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.jpa.exceptions.EncuestaExistenteException;
import es.uma.informatica.sii.jpa.proyect.Encuesta;

@Local
public interface GestionEncuesta {
	
	public void guardarEncuesta(Encuesta e) throws EncuestaExistenteException;
	
}
