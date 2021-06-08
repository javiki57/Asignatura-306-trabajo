package es.uma.informatica.sii.jpa.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.exceptions.EncuestaExistenteException;
import es.uma.informatica.sii.jpa.proyect.Encuesta;

public class EncuestaEJB implements GestionEncuesta{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void guardarEncuesta(Encuesta e) throws EncuestaExistenteException {
		//Encuesta encuesta = em.find(Encuesta.class, primaryKey)
		em.persist(e);
		
	}
	
	
}
