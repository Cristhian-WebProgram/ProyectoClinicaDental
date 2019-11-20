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
@Table(name = "Cliente", uniqueConstraints = { @UniqueConstraint(columnNames = {  "nombreCliente" }) })
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DNI",length =60,nullable=false)
	private int DNI;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="nombreCliente",length =60,nullable=false)
	private String nombreCliente;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="apellidoPaterno",length =60,nullable=false)
	private String apellidoCliente;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="apellidoMaterno",length =60,nullable=false)
	private String domicilioCliente;
	
	@Column(name="telefonoCliente",length =60,nullable=false)
	private int telefonoCliente;

	public Cliente(int DNI,String nombreCliente, String apellidoCliente,String domicilioCliente , int telefonoCliente  ) {
		super();
		
		this.DNI = DNI;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente=apellidoCliente;
		this.domicilioCliente =domicilioCliente;
		this.telefonoCliente = telefonoCliente;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDomicilioCliente() {
		return domicilioCliente;
	}

	public void setDomicilioCliente(String domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}

	public int getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	
	
	
	}