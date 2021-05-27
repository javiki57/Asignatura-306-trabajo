package es.uma.informatica.sii.jpa.proyect;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * ID class for entity: Clase
 *
 */ 
public class ClasePK  implements Serializable {   
   
	         
	private String Dia;         
	private Double Hora_Inicio;
	private Long grupo;
	private static final long serialVersionUID = 1L;

	public ClasePK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ClasePK)) {
			return false;
		}
		ClasePK other = (ClasePK) o;
		return true
			&& (getDia() == null ? other.getDia() == null : getDia().equals(other.getDia()))
			&& (getHora_Inicio() == null ? other.getHora_Inicio() == null : getHora_Inicio().equals(other.getHora_Inicio()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getDia() == null ? 0 : getDia().hashCode());
		result = prime * result + (getHora_Inicio() == null ? 0 : getHora_Inicio().hashCode());
		return result;
	}
   
   
}
