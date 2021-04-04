package modelo.er.jpa.proyect;


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
	private static final long serialVersionUID = 1L;
	@OneToMany (mappedBy="titulacion")
	private List<Expediente> expediente;

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
