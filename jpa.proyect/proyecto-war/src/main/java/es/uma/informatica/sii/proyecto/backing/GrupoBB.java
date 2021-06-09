package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.jpa.ejb.GestionGrupo;
import es.uma.informatica.sii.jpa.ejb.GrupoEJB;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.GrupoExistenteException;
import es.uma.informatica.sii.jpa.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Grupo;

@Named(value="grupo")
@RequestScoped
public class GrupoBB {
	@Inject
	private GestionGrupo grupoejb;
	private Grupo g;
	private Asignatura a;

	
	public void nuevoGrupo() throws AsignaturaNoEncontradaException, GrupoExistenteException {
		
		grupoejb.crearGrupo(a, g);
	}
	
	public Grupo getG() {
		return g;
	}

	public void setG(Grupo g) {
		this.g = g;
	}

	public Asignatura getA() {
		return a;
	}

	public void setA(Asignatura a) {
		this.a = a;
	}

	public void actualizarGrupoBB() throws GrupoNoEncontradoException {
		//sacar datos de la web 
		
		grupoejb.actualizarGrupo(g);
	}
	

}
