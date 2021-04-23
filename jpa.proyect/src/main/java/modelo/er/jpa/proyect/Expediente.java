package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity

public class Expediente implements Serializable {
	
	@Id @GeneratedValue
	private Integer Num_Expediente;
	private Boolean Activa;
	private Integer Nota_Media_Provisional;
	private Integer Creditos_Superados;
	private Integer Creditos_Formacion_Basica;
	private Integer Creditos_Optativos;
	private Integer Creditos_Practicas_Externas;
	private Integer Creditos_TFG;
	private Integer Creditos_CF;
	@ManyToOne
	private Alumno alumno;
	@ManyToOne
	private Titulacion titulacion;
	@OneToMany (mappedBy="expediente")
	private List<Matricula> matricula;
	@OneToMany (mappedBy="expediente")
	private List<Encuesta> encuesta;
	
	
	
	private static final long serialVersionUID = 1L;

	public Expediente() {
		super();
	}

	public Integer getNum_Expediente() {
		return Num_Expediente;
	}

	public void setNum_Expediente(Integer num_Expediente) {
		Num_Expediente = num_Expediente;
	}

	public Boolean getActiva() {
		return Activa;
	}

	public void setActiva(Boolean activa) {
		Activa = activa;
	}

	public Integer getNota_Media_Provisional() {
		return Nota_Media_Provisional;
	}

	public void setNota_Media_Provisional(Integer nota_Media_Provisional) {
		Nota_Media_Provisional = nota_Media_Provisional;
	}

	public Integer getCreditos_Superados() {
		return Creditos_Superados;
	}

	public void setCreditos_Superados(Integer creditos_Superados) {
		Creditos_Superados = creditos_Superados;
	}

	public Integer getCreditos_Formacion_Basica() {
		return Creditos_Formacion_Basica;
	}

	public void setCreditos_Formacion_Basica(Integer creditos_Formacion_Basica) {
		Creditos_Formacion_Basica = creditos_Formacion_Basica;
	}

	public Integer getCreditos_Optativos() {
		return Creditos_Optativos;
	}

	public void setCreditos_Optativos(Integer creditos_Optativos) {
		Creditos_Optativos = creditos_Optativos;
	}

	public Integer getCreditos_Practicas_Externas() {
		return Creditos_Practicas_Externas;
	}

	public void setCreditos_Practicas_Externas(Integer creditos_Practicas_Externas) {
		Creditos_Practicas_Externas = creditos_Practicas_Externas;
	}

	public Integer getCreditos_TFG() {
		return Creditos_TFG;
	}

	public void setCreditos_TFG(Integer creditos_TFG) {
		Creditos_TFG = creditos_TFG;
	}

	public Integer getCreditos_CF() {
		return Creditos_CF;
	}

	public void setCreditos_CF(Integer creditos_CF) {
		Creditos_CF = creditos_CF;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}
	
	
   
}
