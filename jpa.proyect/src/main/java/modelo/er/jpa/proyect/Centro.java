package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Centro implements Serializable{

	@Id
	private int Id;
	@Column (unique = true, nullable = false)
	private String Nombre;
	@Column (nullable = false)
	private String Direccion;
	private int TLF_Conserjeria;

	@ManyToMany
	private List<Titulacion> titulacion;

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getTLF_Conserjeria() {
		return TLF_Conserjeria;
	}
	public void setTLF_Conserjeria(int tLF_Conserjeria) {
		TLF_Conserjeria = tLF_Conserjeria;
	}
	
}
