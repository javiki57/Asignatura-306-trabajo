package modelo.er.jpa.ejb;

import javax.ejb.Local;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.GrupoExistenteException;
import modelo.er.jpa.exceptions.GrupoNoEncontradoException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Asignatura;
import modelo.er.jpa.proyect.Grupo;

@Local
public interface GestionGrupo {
	
	
	void  asignarGrupoAlumno(Alumno a) throws AlumnoNoEncontradoException, GrupoNoEncontradoException;
	
	public void crearGrupo(Asignatura a, Grupo g) throws AsignaturaNoEncontradaException, GrupoExistenteException;
	
	public void borrarGrupo(Grupo g) throws GrupoNoEncontradoException;
	
	//void asignarGrupoAntiguo(Alumno a)throws AlumnoNoEncontradoException, GrupoNoEncontradoException;
		
}
