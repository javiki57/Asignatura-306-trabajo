package modelo.er.jpa.proyect;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Asignatura_Matricula
 *
 */
@Entity
@IdClass(Asignatura_Matricula.Asignatura_Matricula_Id.class)
public class Asignatura_Matricula implements Serializable {

	public static class Asignatura_Matricula_Id implements Serializable{
		private Integer matricula;
		private Integer asignatura;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
			result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Asignatura_Matricula_Id other = (Asignatura_Matricula_Id) obj;
			if (asignatura == null) {
				if (other.asignatura != null)
					return false;
			} else if (!asignatura.equals(other.asignatura))
				return false;
			if (matricula == null) {
				if (other.matricula != null)
					return false;
			} else if (!matricula.equals(other.matricula))
				return false;
			return true;
		} 
		
	}
	
	private static final long serialVersionUID = 1L;

	public Asignatura_Matricula() {
		super();
	}

	@ManyToOne
	private Grupo grupo;
	@Id 
	@ManyToOne
	private Matricula matricula;
	@Id
	@ManyToOne
	private Asignatura asignatura;
   
}
