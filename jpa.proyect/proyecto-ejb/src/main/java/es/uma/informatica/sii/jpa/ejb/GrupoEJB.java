package es.uma.informatica.sii.jpa.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.GrupoExistenteException;
import es.uma.informatica.sii.jpa.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Asignatura_Matricula;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Grupo_por_Asignatura;
import es.uma.informatica.sii.jpa.proyect.Matricula;

@Stateless
public class GrupoEJB implements GestionGrupo {

	@PersistenceContext(name = "Project")
	private EntityManager em;

	//
	//
	//
	
	
	/*Override
	public void asingarGrupoAlumnoV2(Alumno a,Grupo g, Matricula m ) {
		Alumno al = em.find(Alumno.class, a.getId());
		
		if (al == null) {
			throw new AlumnoNoEncontradoException();
			}
		
		
		
		List<Expediente> exp_alumno = al.getExpediente();// Los expedientes del alumno

		
		for (Expediente auxExp : exp_alumno) {
			if (auxExp.getActiva() == true) {// Solo necesito mirar el expediente activo
				
		
	
			}*/
	@Override
	public void asignarGrupoAlumno(Alumno al) throws AlumnoNoEncontradoException, GrupoNoEncontradoException {
		
		if (al == null) {
			throw new AlumnoNoEncontradoException();
		}
		List<Expediente> exp_alumno = al.getExpediente();// Los expedientes del alumno

		for (Expediente auxExp : exp_alumno) {
			if (auxExp.getActiva() == true) {// Solo necesito mirar el expediente activo
				List<Matricula> matriculas = auxExp.getMatriculas();

				for (Matricula aux_mat : matriculas) {// Recorro las matriculas del expediente
					if (aux_mat.getEstado()) {
						List<Asignatura> lista_Asignaturas = aux_mat.getListado_Asignaturas();

						for (Asignatura aux_asignatura : lista_Asignaturas) {
							if (aux_asignatura.getIdioma() == "Ingles") {// Si el alumno tiene alguna asignatura en
																			// ingles se le asignara a un grupo que sea
																			// de ingles
								List<Asignatura_Matricula> asign_mat = aux_mat.getAsignatura_matricula();
								int i = 0;
								Grupo g = asign_mat.get(i).getGrupo();
								while (g.getPlazas() == 0 || !g.getIngles()) {
									i++;
								}
								asign_mat.get(i).setGrupo(g);

							} else {// Si no tiene asignaturas en ingles
								List<Asignatura_Matricula> asign_mat = aux_mat.getAsignatura_matricula();
								int i = 0;
								Grupo g = asign_mat.get(i).getGrupo();
								while (g.getPlazas() == 0) {
									i++;
								}
								asign_mat.get(i).setGrupo(g);//Se le asigna el grupo disponible
							}
							break;// Salgo del bucle de asignaturas del alumno sabiendo que tiene una asignatura
									// en ingles.
						}

					}
					break;// salgo de la busqueda de la matricula de nuevo ingreso y de matricula
							// "activa".

				}
				break;// salgo de la busqueda de expedientes activos.
			}

		}
	}
	/*
	 * @Override public void asignarGrupoAntiguo(Alumno a)throws
	 * AlumnoNoEncontradoException, GrupoNoEncontradoException { Alumno al =
	 * em.find(Alumno.class, a.getId()); if(al==null) { throw new
	 * AlumnoNoEncontradoException(); }
	 * 
	 * List<Expediente> exp_alumno= al.getExpediente();//Los expedientes del alumno
	 * 
	 * for(Expediente auxExp : exp_alumno) { if(auxExp.getActiva()==true) {//Solo
	 * necesito mirar el expediente activo List<Matricula> matriculas =
	 * auxExp.getMatriculas(); for(Matricula aux_mat : matriculas) {//Recorro las
	 * matriculas del expediente if(aux_mat.getEstado()) { List<Asignatura>
	 * lista_Asignaturas = aux_mat.getListado_Asignaturas();
	 * 
	 * for(Asignatura aux_asignatura : lista_Asignaturas) {
	 * if(aux_asignatura.getIdioma()=="Ingles") { List<Asignatura_Matricula>
	 * asign_mat = aux_mat.getAsignatura_matricula();
	 * 
	 * int i=0; while( asign_mat.get(i).getGrupo().getPlazas() > 0){
	 * asign_mat.get(0).setGrupo(asign_mat.get(i).getGrupo()); break; }
	 * 
	 * } break;//Salgo del bucle de asignaturas del alumno sabiendo que tiene una
	 * asignatura en ingles. }
	 * 
	 * } break;//salgo de la busqueda de la matricula de nuevo ingreso y de
	 * matricula "activa".
	 * 
	 * } break;//salgo de la busqueda de expedientes activos. }
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	@Override
	public void crearGrupo(Asignatura a, Grupo g) throws AsignaturaNoEncontradaException, GrupoExistenteException {
		// TODO Auto-generated method stub
		if(a==null) {
			throw new AsignaturaNoEncontradaException();
		}
		
		if(g!=null) {
			throw new GrupoExistenteException();
		}
		
		Grupo_por_Asignatura gpa = new Grupo_por_Asignatura();
		gpa.setAsignaturas(a);
		List<Grupo_por_Asignatura> listaGrupoAsig = new ArrayList();
		listaGrupoAsig.add(gpa);
		g.setGrupo(listaGrupoAsig);
		em.persist(g);
		
	}

	@Override
	public void borrarGrupo(Grupo g) throws GrupoNoEncontradoException {
		// TODO Auto-generated method stub
		
		if(g==null) {
			throw new GrupoNoEncontradoException();
		}
		
		em.remove(g);
		
	}
	
	public Grupo mostrarGrupo(Grupo g) throws GrupoNoEncontradoException {
		
		Grupo resultado = null;
			
		if(g == null) {
			throw new GrupoNoEncontradoException();
		}
		
		List<Grupo> grupos = g.getGrupos();
		
		for(Grupo gru : grupos) {
			if(gru.equals(g)) {
				resultado = gru;
			}
		}
		
		return resultado;
	}

	@Override
	public void actualizarGrupo(Grupo g) throws GrupoNoEncontradoException {
		// TODO Auto-generated method stub
		
		
		if(g == null) {
			throw new GrupoNoEncontradoException();
		}
		
		g.setAsig_matr(g.getAsig_matr());
		g.setAsignar(g.getAsignar());
		g.setClases(g.getClases());
		g.setCurso(g.getCurso());
		g.setGrupo(g.getGrupo());
		g.setIngles(g.getIngles());
		g.setLetra(g.getLetra());
		g.setPlazas(g.getPlazas());
		g.setTurno_Mañana_Tarde(g.getTurno_Mañana_Tarde());
		g.setVisible(g.getVisible());
		
		
		em.merge(g);
	}
	
	

}
