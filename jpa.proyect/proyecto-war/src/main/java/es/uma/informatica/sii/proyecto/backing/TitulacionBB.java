package es.uma.informatica.sii.proyecto.backing;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.GestionTitulacion;
import es.uma.informatica.sii.jpa.ejb.TitulacionEJB;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Named(value="titulacion")
@RequestScoped
public class TitulacionBB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionTitulacion titulacionejb;
	private Titulacion t;
	
	public TitulacionBB() {
		
	}
	
	public String crearTitulacion() {
		titulacionejb.crearTitulacion(t);
		return "vistaSecretario.xhtml";
	}
	
	public void actualizarTitulacion() {
		titulacionejb.actualizarTitulacion(t);
	}

	public Titulacion getT() {
		return t;
	}

	public void setT(Titulacion t) {
		this.t = t;
	}
}
