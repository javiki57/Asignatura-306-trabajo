package modelo.er.jpa.proyect;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulación
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @GeneratedValue
	private Integer Código;
	private String Nombre;
	private Integer Créditos;
	private static final long serialVersionUID = 1L;

	public Titulacion() {
		super();
	}   
	public Integer getCódigo() {
		return this.Código;
	}

	public void setCódigo(Integer Código) {
		this.Código = Código;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Integer getCréditos() {
		return this.Créditos;
	}

	public void setCréditos(Integer Créditos) {
		this.Créditos = Créditos;
	}
   
}
