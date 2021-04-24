package modelo.er.jpa.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.GrupoExistenteException;
import modelo.er.jpa.exceptions.GrupoNoEncontradoException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Asignatura;
import modelo.er.jpa.proyect.Asignatura_Matricula;
import modelo.er.jpa.proyect.Expediente;
import modelo.er.jpa.proyect.Grupo;
import modelo.er.jpa.proyect.Grupo_por_Asignatura;
import modelo.er.jpa.proyect.Matricula;

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
	public void asignarGrupoAlumno(Alumno a) throws AlumnoNoEncontradoException, GrupoNoEncontradoException {
		Alumno al = em.find(Alumno.class, a.getId());
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
		Asignatura as = em.find(Asignatura.class, a.getReferencia());
		if(as==null) {
			throw new AsignaturaNoEncontradaException();
		}
		
		Grupo nuevoGrupo = em.find(Grupo.class, g.getId());
		if(nuevoGrupo!=null) {
			throw new GrupoExistenteException();
		}
		
		Grupo_por_Asignatura gpa = new Grupo_por_Asignatura();
		gpa.setAsignaturas(as);
		List<Grupo_por_Asignatura> listaGrupoAsig = new ArrayList();
		listaGrupoAsig.add(gpa);
		nuevoGrupo.setGrupo(listaGrupoAsig);
		em.persist(nuevoGrupo);
		
	}

	@Override
	public void borrarGrupo(Grupo g) throws GrupoNoEncontradoException {
		// TODO Auto-generated method stub
		Grupo gr = em.find(Grupo.class, g.getId());
		if(gr==null) {
			throw new GrupoNoEncontradoException();
		}
		
		em.remove(gr);
		
	}
	
	public Grupo mostrarGrupo(Grupo g) throws GrupoNoEncontradoException {
		
		Grupo grupo = em.find(Grupo.class, g.getId());
		
		Grupo resultado = null;
			
		if(grupo == null) {
			throw new GrupoNoEncontradoException();
		}
		
		List<Grupo> grupos = grupo.getGrupos();
		
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
		
		Grupo grupo = em.find(Grupo.class, g.getId());
		
		if(grupo == null) {
			throw new GrupoNoEncontradoException();
		}
		
		grupo.setAsig_matr(g.getAsig_matr());
		grupo.setAsignar(g.getAsignar());
		grupo.setClases(g.getClases());
		grupo.setCurso(g.getCurso());
		grupo.setGrupo(g.getGrupo());
		grupo.setIngles(g.getIngles());
		grupo.setLetra(g.getLetra());
		grupo.setPlazas(g.getPlazas());
		grupo.setTurno_Mañana_Tarde(g.getTurno_Mañana_Tarde());
		grupo.setVisible(g.getVisible());
		
		
		em.merge(grupo);
	}
	
	

}
