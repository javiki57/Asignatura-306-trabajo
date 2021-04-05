package modelo.er.jpa.proyect;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura_Matricula
 *
 */
@Entity
@IdClass(Asignatura_Matricula.Asignatura_MatriculaId.class)
public class Asignatura_Matricula implements Serializable {
	
	public class Asignatura_MatriculaId implements Serializable {
		private Integer matricula;
		private Integer asignatura;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
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
			Asignatura_MatriculaId other = (Asignatura_MatriculaId) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
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
		private Asignatura_Matricula getEnclosingInstance() {
			return Asignatura_Matricula.this;
		}
	}
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Grupo grupo;
	@Id
	@ManyToOne
	private Matricula matricula;
	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	public Asignatura_Matricula() {
		super();
	}
	
   
}
