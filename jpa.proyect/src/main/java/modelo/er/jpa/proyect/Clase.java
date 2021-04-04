package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity

@IdClass(ClasePK.class)
public class Clase implements Serializable {

	   
	@Id @Column(nullable=false)
	private String Dia;   
	@Id @Column(nullable=false)
	private Double Hora_Inicio;
	private Double Hora_Fin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne 
	
	private Grupo grupo;
	
	@ManyToOne
	
	private Asignatura asignatura;

	
	public Clase() {
		super();
	}   
	public String getDia() {
		return this.Dia;
	}

	public void setDia(String Dia) {
		this.Dia = Dia;
	}   
	public Double getHora_Inicio() {
		return this.Hora_Inicio;
	}

	public void setHora_Inicio(Double Hora_Inicio) {
		this.Hora_Inicio = Hora_Inicio;
	}   
	public Double getHora_Fin() {
		return this.Hora_Fin;
	}

	public void setHora_Fin(Double Hora_Fin) {
		this.Hora_Fin = Hora_Fin;
	}
   
}
