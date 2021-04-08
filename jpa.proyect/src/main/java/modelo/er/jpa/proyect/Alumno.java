package modelo.er.jpa.proyect;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Alumno
 * @param <T>
 *
 */
@Entity

public class Alumno<T> implements Serializable {

	   
	@Id @GeneratedValue
	private Integer Id;
	@Column(unique = true, nullable = false)
	private String DNI;
	@Column(nullable = false)
	private String Nombre_Completo;
	@Column(nullable = false)
	private String Email_Institucional;
	private String Email_Personal;
	private Integer Telefono;
	private Integer Movil;
	private String Direccion_Notificacion;
	private String Codigo_Postal_Notificacion;
	@Temporal (TemporalType.DATE)
	private Date Fecha_Nacimiento;
	private static final long serialVersionUID = 1L;

	@OneToMany (mappedBy = "alumno")
	private List<Expediente> expediente;
	
	
	public Alumno() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre_Completo() {
		return this.Nombre_Completo;
	}

	public void setNombre_Completo(String Nombre_Completo) {
		this.Nombre_Completo = Nombre_Completo;
	}   
	public String getEmail_Institucional() {
		return this.Email_Institucional;
	}

	public void setEmail_Institucional(String Email_Institucional) {
		this.Email_Institucional = Email_Institucional;
	}   
	public String getEmail_Personal() {
		return this.Email_Personal;
	}

	public void setEmail_Personal(String Email_Personal) {
		this.Email_Personal = Email_Personal;
	}   
	public Integer getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
	}   
	public Integer getMovil() {
		return this.Movil;
	}

	public void setMovil(Integer Movil) {
		this.Movil = Movil;
	}   
	public String getDireccion_Notificacion() {
		return this.Direccion_Notificacion;
	}

	public void setDireccion_Notificacion(String Direccion_Notificacion) {
		this.Direccion_Notificacion = Direccion_Notificacion;
	}   
	public String getCodigo_Postal_Notificacion() {
		return this.Codigo_Postal_Notificacion;
	}

	public void setCodigo_Postal_Notificacion(String Codigo_Postal_Notificacion) {
		this.Codigo_Postal_Notificacion = Codigo_Postal_Notificacion;
	}   
	public String getFecha_Nacimiento() {
		return this.Fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String Fecha_Nacimiento) {
		this.Fecha_Nacimiento = Fecha_Nacimiento;
	}
   
}
