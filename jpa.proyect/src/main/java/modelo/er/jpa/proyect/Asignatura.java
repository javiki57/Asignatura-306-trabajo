package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity

public class Asignatura implements Serializable {

	   
	@Id @GeneratedValue
	private Integer Referencia;
	@Column(nullable = false)
	private Integer Codigo;
	@Column(nullable = false)
	private Integer Creditos;
	@Column(nullable = false)
	private boolean Ofertada;
	@Column(nullable = false)
	private String Nombre;
	private Integer Curso;
	private String Caracter;
	private Integer Duracion;
	private Integer Unidad_Temporal;
	private String Idioma;
	private String Departamento;
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		super();
	}   
	public Integer getReferencia() {
		return this.Referencia;
	}

	public void setReferencia(Integer Referencia) {
		this.Referencia = Referencia;
	}   
	public Integer getCódigo() {
		return this.Codigo;
	}

	public void setCódigo(Integer Código) {
		this.Codigo = Código;
	}   
	public Integer getCréditos() {
		return this.Creditos;
	}

	public void setCréditos(Integer Créditos) {
		this.Creditos = Créditos;
	}   
	public boolean getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(boolean Ofertada) {
		this.Ofertada = Ofertada;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Integer getCurso() {
		return this.Curso;
	}

	public void setCurso(Integer Curso) {
		this.Curso = Curso;
	}   
	public String getCaracter() {
		return this.Caracter;
	}

	public void setCaracter(String Caracter) {
		this.Caracter = Caracter;
	}   
	public Integer getDuración() {
		return this.Duracion;
	}

	public void setDuración(Integer Duración) {
		this.Duracion = Duración;
	}   
	public Integer getUnidad_Temporal() {
		return this.Unidad_Temporal;
	}

	public void setUnidad_Temporal(Integer Unidad_Temporal) {
		this.Unidad_Temporal = Unidad_Temporal;
	}   
	public String getIdioma() {
		return this.Idioma;
	}

	public void setIdioma(String Idioma) {
		this.Idioma = Idioma;
	}   
	public String getDepartamento() {
		return this.Departamento;
	}

	public void setDepartamento(String Departamento) {
		this.Departamento = Departamento;
	}
   
}
