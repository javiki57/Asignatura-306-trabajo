package es.uma.informatica.sii.jpa.proyect;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id @GeneratedValue
	private Long id;
	@Column (unique = true, nullable = false)
	private String Curso;
	@Column (unique = true, nullable = false)
	private Character Letra;
	@Column(nullable = false)
	private String Turno_Mañana_Tarde;
	@Column(nullable = false)
	private Boolean Ingles;
	private Boolean Visible;
	private String Asignar;
	private Integer Plazas;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Titulacion titulacion;

	
	@OneToMany (mappedBy="grup0")
	private List<Grupo> group;
	@ManyToOne
	private Grupo grup0;
	
	
	@OneToMany //(targetEntity=Grupo_por_Asignatura.class, mappedBy="grupos")
	private List<Grupo_por_Asignatura> grupo;

	public List<Grupo_por_Asignatura> getGrupo() {
		return grupo;
	}
	public void setGrupo(List<Grupo_por_Asignatura> grupo) {
		this.grupo = grupo;
	}

	@OneToMany//(targetEntity=Clase.class, mappedBy="grupo")
	private List<Clase> clases;
	
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public List<Asignatura_Matricula> getAsig_matr() {
		return asig_matr;
	}
	public void setAsig_matr(List<Asignatura_Matricula> asig_matr) {
		this.asig_matr = asig_matr;
	}

	@OneToMany(mappedBy="grupo")
	private List<Asignatura_Matricula> asig_matr;
	
	
	public Grupo() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

 
	public String getCurso() {
		return this.Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}   
	public Character getLetra() {
		return this.Letra;
	}

	public void setLetra(Character Letra) {
		this.Letra = Letra;
	}   
	public String getTurno_Mañana_Tarde() {
		return this.Turno_Mañana_Tarde;
	}

	public void setTurno_Mañana_Tarde(String Turno_Mañana_Tarde) {
		this.Turno_Mañana_Tarde = Turno_Mañana_Tarde;
	}   
	public Boolean getIngles() {
		return this.Ingles;
	}

	public void setIngles(Boolean Inglés) {
		this.Ingles = Inglés;
	}   
	public Boolean getVisible() {
		return this.Visible;
	}

	public void setVisible(Boolean Visible) {
		this.Visible = Visible;
	}   
	public String getAsignar() {
		return this.Asignar;
	}

	public void setAsignar(String Asignar) {
		this.Asignar = Asignar;
	}   
	public Integer getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Integer Plazas) {
		this.Plazas = Plazas;
	}
	
	public List<Grupo> getGrupos(){
		return this.group;
	}
	public Titulacion getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}
	public List<Grupo> getGroup() {
		return group;
	}
	public void setGroup(List<Grupo> group) {
		this.group = group;
	}
	public Grupo getGrup0() {
		return grup0;
	}
	public void setGrup0(Grupo grup0) {
		this.grup0 = grup0;
	}
	
   
}