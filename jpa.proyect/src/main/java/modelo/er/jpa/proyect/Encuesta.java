package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Encuesta implements Serializable{

	@Id
	@Temporal (TemporalType.DATE)
	private Date Fecha_de_Envio;
	
	@ManyToMany
	private List<Grupo_por_Asignatura> grupo_por_asignatura;
	
	@ManyToOne
	private Expediente expediente;

}
