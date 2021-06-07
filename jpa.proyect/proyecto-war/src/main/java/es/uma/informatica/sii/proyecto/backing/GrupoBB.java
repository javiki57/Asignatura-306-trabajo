package es.uma.informatica.sii.proyecto.backing;

import es.uma.informatica.sii.jpa.ejb.GrupoEJB;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.GrupoExistenteException;
import es.uma.informatica.sii.jpa.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Grupo;

public class GrupoBB {
	private GrupoEJB grupoejb;
	
	public String verGrupos() {
		return "vistagrupo.xhtml";
	}
	
	public void nuevoGrupo() throws AsignaturaNoEncontradaException, GrupoExistenteException {
		Grupo g = new Grupo();
		Asignatura a = new Asignatura();
		//Sacar los datos del formulario. Hay que sacar la letra y el curso
		//g.setLetra(letra);
		//g.setCurso(curso);
		grupoejb.crearGrupo(a, g);
	}
	
	public void actualizarGrupoBB() throws GrupoNoEncontradoException {
		Grupo g = new Grupo();
		//sacar datos de la web 
		
		grupoejb.actualizarGrupo(g);
	}
	

}
