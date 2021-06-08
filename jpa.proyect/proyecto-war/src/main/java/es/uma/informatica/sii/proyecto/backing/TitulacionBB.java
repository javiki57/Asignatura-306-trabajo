package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.TitulacionEJB;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Named(value="titulacion")
@RequestScoped
public class TitulacionBB {
	
	@Inject
	private TitulacionEJB titulacionejb;
	private Titulacion t;
	
	public void crearTitulacion() {
		titulacionejb.crearTitulacion(t);
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
