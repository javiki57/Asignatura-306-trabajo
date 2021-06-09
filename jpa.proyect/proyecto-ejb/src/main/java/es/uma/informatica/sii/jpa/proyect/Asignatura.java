package es.uma.informatica.sii.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

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
	@Embedded
	private Optativa optativa;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (targetEntity=Grupo_por_Asignatura.class, mappedBy="asignaturas")
	private List<Grupo_por_Asignatura> asignatura;
	
	@OneToMany (targetEntity=Clase.class, mappedBy="asignatura")
	private List<Clase> clase;
	
	@ManyToOne  
	private Titulacion titulacion;
	
	@OneToMany (mappedBy="asignatura")
	private List<Asignatura_Matricula> asig_matr;

	public Asignatura() {
		super();
	}   
	public Integer getReferencia() {
		return this.Referencia;
	}

	public void setReferencia(Integer Referencia) {
		this.Referencia = Referencia;
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}   
	public boolean getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(boolean Ofertada) {
		this.Ofertada = Ofertada;
	}   
	public Optativa getOptativa() {
		return optativa;
	}
	public void setOptativa(Optativa optativa) {
		this.optativa = optativa;
	}
	public List<Grupo_por_Asignatura> getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(List<Grupo_por_Asignatura> asignatura) {
		this.asignatura = asignatura;
	}
	public List<Clase> getClase() {
		return clase;
	}
	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public List<Asignatura_Matricula> getAsig_matr() {
		return asig_matr;
	}
	public void setAsig_matr(List<Asignatura_Matricula> asig_matr) {
		this.asig_matr = asig_matr;
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
	public Integer getDuracion() {
		return this.Duracion;
	}

	public void setDuracion(Integer Duracion) {
		this.Duracion = Duracion;
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
   
	@Embeddable
	public static class Optativa{
		private Integer plazas;
		private String mencion;
		
	}

	
}


