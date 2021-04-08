package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity
@IdClass(Matricula.MatriculaID.class)
public class Matricula implements Serializable {

	public static class MatriculaID implements Serializable{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
			result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
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
			MatriculaID other = (MatriculaID) obj;
			if (Curso_Academico == null) {
				if (other.Curso_Academico != null)
					return false;
			} else if (!Curso_Academico.equals(other.Curso_Academico))
				return false;
			if (expediente == null) {
				if (other.expediente != null)
					return false;
			} else if (!expediente.equals(other.expediente))
				return false;
			return true;
		}
		private Integer Curso_Academico;
		private Integer expediente;
	}
	
	@Id
	private Integer Curso_Academico;
	@Column (nullable = false)
	private String Estado;
	private Integer Num_Archivo;
	private String Turno_Preferente;
	@Column (nullable = false) @Temporal (TemporalType.DATE)
	private Date Fecha_de_Matricula;
	private Boolean Nuevo_Ingreso;
	@ElementCollection (fetch = FetchType.LAZY)
	
	private List<Asignatura> Listado_Asignaturas;
	
	@Id
	@ManyToOne
	private Expediente expediente;
	@OneToMany (mappedBy="matricula")
	private List<Asignatura_Matricula> asignatura_matricula;
	
	
	public Integer getCurso_Academico() {
		return Curso_Academico;
	}

	public void setCurso_Academico(Integer curso_Academico) {
		Curso_Academico = curso_Academico;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Integer getNum_Archivo() {
		return Num_Archivo;
	}

	public void setNum_Archivo(Integer num_Archivo) {
		Num_Archivo = num_Archivo;
	}

	public String getTurno_Preferente() {
		return Turno_Preferente;
	}

	public void setTurno_Preferente(String turno_Preferente) {
		Turno_Preferente = turno_Preferente;
	}

	public Date getFecha_de_Matricula() {
		return Fecha_de_Matricula;
	}

	public void setFecha_de_Matricula(Date fecha_de_Matricula) {
		Fecha_de_Matricula = fecha_de_Matricula;
	}

	public Boolean getNuevo_Ingreso() {
		return Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(Boolean nuevo_Ingreso) {
		Nuevo_Ingreso = nuevo_Ingreso;
	}

	public List<Asignatura> getListado_Asignaturas() {
		return Listado_Asignaturas;
	}

	public void setListado_Asignaturas(List<Asignatura> listado_Asignaturas) {
		Listado_Asignaturas = listado_Asignaturas;
	}

	private static final long serialVersionUID = 1L;

	public Matricula() {
		super();
	}
   
}
