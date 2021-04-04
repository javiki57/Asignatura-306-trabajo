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

public class Matricula implements Serializable {
	
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