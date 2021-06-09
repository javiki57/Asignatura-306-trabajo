package es.uma.informatica.sii.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.exceptions.TitulacionNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.Centro;
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
	
	public Titulacion buscarTitulacion(String nombre) throws TitulacionNoEncontradaException {
		
		Titulacion tit = em.find(Titulacion.class, nombre);
		
		if(tit == null)
			throw new TitulacionNoEncontradaException();
		
		return tit;
	}
	
	public List<Titulacion> mostrarTitulaciones(Centro centro){
		int centroID = centro.getId();
		return (List<Titulacion>) em.createQuery("SELECT TITULACION FROM CENTRO WHERE id = centroID");
		
	}
	
	
}
