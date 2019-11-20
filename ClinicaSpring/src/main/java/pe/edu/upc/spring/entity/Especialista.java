package pe.edu.upc.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Especialista", uniqueConstraints = { @UniqueConstraint(columnNames = {  "nombreEspecialista" }) })
public class Especialista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecialista;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="nombreEspecialista",length =60,nullable=false)
	private String nombreEspecialista;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="apellidoEspecialista",length =60,nullable=false)
	private String apellidoEspecialista;
	
	@Column(name="telefono",length =60,nullable=false)
	private int telefono;
	
	@Column(name="direccion",length =60,nullable=false)
	private String direccion;
	
	@Column(name="nombreEspecialidad",length =60,nullable=false)
	private String nombreEspecialidad;
	
	public Especialista(int idEspecialista,int idCliente,String nombreEspecialista, String apellidoEspecialista, int telefono , String direccion, String nombreEspecialidad  ) {
		super();
		
		this.idEspecialista = idEspecialista;
		this.nombreEspecialista = nombreEspecialista;
		this.apellidoEspecialista =apellidoEspecialista;
		this.telefono = telefono;
		this.direccion=direccion;
		this.nombreEspecialidad=nombreEspecialidad;
		
	}
	
	public Especialista() {
		super();
		
	}

	public int getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String getNombreEspecialista() {
		return nombreEspecialista;
	}

	public void setNombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}

	public String getApellidoEspecialista() {
		return apellidoEspecialista;
	}

	public void setApellidoEspecialista(String apellidoEspecialista) {
		this.apellidoEspecialista = apellidoEspecialista;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	
}
	