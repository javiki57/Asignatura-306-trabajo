package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo_por_Asignatura
 *
 */
@Entity

public class Grupo_por_Asignatura implements Serializable {

	   
	@Id @Column(nullable=false)
	private Integer Curso_Academica;
	private Integer Oferta;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	
	private Asignatura asignaturas;
	
	@ManyToOne
	
	private Grupo grupos;
	
	//@ManyToOne
	
	//private Encuesta encuestas;

	public Grupo_por_Asignatura() {
		super();
	}   
	public Integer getCurso_Academica() {
		return this.Curso_Academica;
	}

	public void setCurso_Academica(Integer Curso_Academica) {
		this.Curso_Academica = Curso_Academica;
	}   
	public Integer getOferta() {
		return this.Oferta;
	}

	public void setOferta(Integer Oferta) {
		this.Oferta = Oferta;
	}
   
}
