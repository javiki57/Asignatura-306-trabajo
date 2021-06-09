package es.uma.informatica.sii.jpa.proyect;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulación
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @GeneratedValue 
	private Integer Codigo;
	@Column(nullable = false)
	private String Nombre;
	@Column(nullable = false)
	private Integer Creditos;
	public List<Expediente> getExpediente() {
		return expediente;
	}
	public void setExpediente(List<Expediente> expediente) {
		this.expediente = expediente;
	}
	public List<Grupo> getGrupo() {
		return grupo;
	}
	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	public List<Centro> getCentro() {
		return centro;
	}
	public void setCentro(List<Centro> centro) {
		this.centro = centro;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy="titulacion")
	private List<Expediente> expediente;

	@OneToMany (mappedBy="titulacion")
	private List<Grupo> grupo;

	
	@ManyToMany (mappedBy="titulacion")
	private List<Centro> centro;
	
	@OneToMany
	private List<Asignatura> asignaturas;
	

	public Titulacion() {
		super();
	}   
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}
   
}
