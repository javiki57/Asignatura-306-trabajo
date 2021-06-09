package es.uma.informatica.sii.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo_por_Asignatura
 *
 */
@Entity
@IdClass(Grupo_por_Asignatura.GrupoId.class)
public class Grupo_por_Asignatura implements Serializable {

	public static class GrupoId implements Serializable{
	private Integer asignaturas;
	private Long grupos;
	private Integer Curso_Academico;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoId other = (GrupoId) obj;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}
	
	
	}
	
	@Id @Column(nullable=false)
	private Integer Curso_Academico;
	private Integer Oferta;
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	private Asignatura asignaturas;
	
	public Asignatura getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Asignatura asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Id
	@ManyToOne
	private Grupo grupos;
	
	@ManyToMany (mappedBy = "grupo_por_asignatura")
	private List<Encuesta> encuestas;

	public Grupo_por_Asignatura() {
		super();
	}   
	public Integer getCurso_Academico() {
		return this.Curso_Academico;
	}

	public void setCurso_Academico(Integer Curso_Academica) {
		this.Curso_Academico = Curso_Academica;
	}   
	public Integer getOferta() {
		return this.Oferta;
	}

	public Grupo getGrupos() {
		return grupos;
	}
	public void setGrupos(Grupo grupos) {
		this.grupos = grupos;
	}
	public List<Encuesta> getEncuestas() {
		return encuestas;
	}
	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}
	public void setOferta(Integer Oferta) {
		this.Oferta = Oferta;
	}
   
}
