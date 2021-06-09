package es.uma.informatica.sii.jpa.proyect;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Encuesta implements Serializable{

	@Id// @GeneratedValue
	@Temporal (TemporalType.DATE)
	private Date Fecha_de_Envio;
	
	@ManyToMany 
	private List<Grupo_por_Asignatura> grupo_por_asignatura;
	
	@ManyToOne
	private Expediente expediente;

	public Date getFecha_de_Envio() {
		return Fecha_de_Envio;
	}

	public void setFecha_de_Envio(Date fecha_de_Envio) {
		Fecha_de_Envio = fecha_de_Envio;
	}

	public List<Grupo_por_Asignatura> getGrupo_por_asignatura() {
		return grupo_por_asignatura;
	}

	public void setGrupo_por_asignatura(List<Grupo_por_Asignatura> grupo_por_asignatura) {
		this.grupo_por_asignatura = grupo_por_asignatura;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

}
