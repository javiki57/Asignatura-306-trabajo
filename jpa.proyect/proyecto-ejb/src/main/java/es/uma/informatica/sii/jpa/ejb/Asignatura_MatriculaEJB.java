package es.uma.informatica.sii.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.proyect.Asignatura_Matricula;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Matricula;
import es.uma.informatica.sii.jpa.proyect.Titulacion;

@Stateless
public class Asignatura_MatriculaEJB implements GestionAsignatura_Matricula{
	
	@PersistenceContext(name="Project")
	private EntityManager em;

	@Override
	public void intercambiarGrupos(Expediente exp, Grupo gActual, Grupo gNuevo, Titulacion titu) {
		// TODO
		Matricula matricula;
		Asignatura_Matricula asma = new Asignatura_Matricula();
		//em.find(matricula, exp.getNum_Expediente());
		
		
	}
	
	 

}
