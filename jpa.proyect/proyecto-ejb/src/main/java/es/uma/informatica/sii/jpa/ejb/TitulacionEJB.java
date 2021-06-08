package es.uma.informatica.sii.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Stateless
public class TitulacionEJB implements GestionTitulacion{


	@PersistenceContext(name="Project")
	private EntityManager em;
	
	public void crearTitulacion(Titulacion t) {
		em.persist(t);
	}
	
	public void actualizarTitulacion(Titulacion t) {
		em.merge(t);
	}
	
	
}
