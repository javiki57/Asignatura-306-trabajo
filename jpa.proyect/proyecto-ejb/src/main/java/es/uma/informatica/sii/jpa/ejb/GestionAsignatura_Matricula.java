package es.uma.informatica.sii.jpa.ejb;

import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

public interface GestionAsignatura_Matricula {
	
	public void intercambiarGrupos(Expediente exp, Grupo gActual, Grupo gNuevo, Titulacion titu);
}
