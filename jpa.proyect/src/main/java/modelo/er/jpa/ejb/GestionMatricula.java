package modelo.er.jpa.ejb;

import java.util.List;

import javax.ejb.Local;
import modelo.er.jpa.proyect.*;


@Local
public interface GestionMatricula {

	public void aniadirAsignatura(Asignatura a, Matricula m);
	
	public void eliminarAsignatura(Asignatura a, Matricula m);
	
	public List<Matricula> mostrarMatriculas(Matricula m);
	
}
