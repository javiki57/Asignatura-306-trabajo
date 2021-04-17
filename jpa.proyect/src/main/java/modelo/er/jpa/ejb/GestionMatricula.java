package modelo.er.jpa.ejb;

import java.util.List;

import javax.ejb.Local;
import modelo.er.jpa.proyect.*;


@Local
public interface GestionMatricula {

	public void aniadirAsignatura(Asignatura a);
	
	public void eliminarAsignatura();
	
	public List<Matricula> mostrarMatriculas();
	
}
