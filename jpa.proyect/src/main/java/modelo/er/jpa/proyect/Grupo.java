package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id @GeneratedValue
	private Long id;
	private String Curso;
	private Character Letra;
	private String Turno_Mañana_Tarde;
	private Boolean Inglés;
	private Boolean Visible;
	private String Asignar;
	private Integer Plazas;
	private static final long serialVersionUID = 1L;

	public Grupo() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Boolean getInglés() {
		return this.Inglés;
	}

	public void setInglés(Boolean Inglés) {
		this.Inglés = Inglés;
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
   
}