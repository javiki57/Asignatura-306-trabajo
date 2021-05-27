package es.uma.informatica.sii.jpa.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.GrupoExistenteException;
import es.uma.informatica.sii.jpa.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Grupo;

@Local
public interface GestionGrupo {
	
	
	void  asignarGrupoAlumno(Alumno a) throws AlumnoNoEncontradoException, GrupoNoEncontradoException;
	
	public void crearGrupo(Asignatura a, Grupo g) throws AsignaturaNoEncontradaException, GrupoExistenteException;
	
	public void borrarGrupo(Grupo g) throws GrupoNoEncontradoException;
	
	//void asignarGrupoAntiguo(Alumno a)throws AlumnoNoEncontradoException, GrupoNoEncontradoException;
	
	public Grupo mostrarGrupo(Grupo g) throws GrupoNoEncontradoException;
	
	public void actualizarGrupo(Grupo g) throws GrupoNoEncontradoException;
		
}
