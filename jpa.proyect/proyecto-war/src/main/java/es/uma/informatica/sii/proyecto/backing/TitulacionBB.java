package es.uma.informatica.sii.proyecto.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.GestionTitulacion;
import es.uma.informatica.sii.jpa.proyect.Titulacion;


@Named(value="TitulacionBB")
@RequestScoped
public class TitulacionBB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionTitulacion titulacionejb;
	private Titulacion t;
	private List<Titulacion> titulaciones;
	
	public TitulacionBB() {
		
	}
	
	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}

	public String crearTitulacion() {
		titulacionejb.crearTitulacion(t);
		return "vistaSecretario.xhtml";
	}
	
	public void actualizarTitulacion() {
		titulacionejb.actualizarTitulacion(t);
	}
	
	public List<Titulacion> getTitulaciones(){
		this.titulaciones = titulacionejb.mostrarTitulaciones(/*"ETSII"*/);
		List<Titulacion> tlista = new ArrayList <>();
		Titulacion titu = new Titulacion();
		titu.setCodigo(1);
		titu.setCreditos(240);
		titu.setNombre("Informatica");
		tlista.add(titu);
		return tlista;
	}

	public Titulacion getT() {
		return t;
	}

	public void setT(Titulacion t) {
		this.t = t;
	}
}
