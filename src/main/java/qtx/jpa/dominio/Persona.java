package qtx.jpa.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_persona")
	private int idPersona;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	
	public Persona() {
		super();
	}
	public Persona(int idPersona, String nombre, String direccion,
			Date fechaNacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

}
