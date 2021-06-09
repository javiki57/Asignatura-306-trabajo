package es.uma.informatica.sii.jpa.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.jpa.exceptions.TitulacionNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.Centro;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Local
public interface GestionTitulacion {
	public void crearTitulacion(Titulacion t);
	public void actualizarTitulacion(Titulacion t) ;
	public List<Titulacion> mostrarTitulaciones(Centro c);
	
}
