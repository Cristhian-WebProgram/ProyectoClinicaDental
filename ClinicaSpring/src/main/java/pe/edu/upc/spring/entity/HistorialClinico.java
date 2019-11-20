package pe.edu.upc.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "HistorialClinico")
public class HistorialClinico implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorialClinico;
	
	
	@Column(name ="descripcion", length=60, nullable=false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idservicio", nullable = false)
	private Servicio idServicio;
	
	@ManyToOne
	@JoinColumn(name = "idespecialista", nullable = false)
	private Especialista idEspecialista;

	@ManyToOne
	@JoinColumn(name = "DNI", nullable = false)
	private Cliente DNI;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fecha;
	
	@Column(name ="hora", length=60, nullable=false)
	private int hora;
	

	
	
	
	public HistorialClinico(int idHistorialClinico, String descripcion,Servicio idServicio, Especialista idEspecialista, Cliente DNI, int hora , Date fecha) {
		super();
		this.idHistorialClinico = idHistorialClinico;
		this.descripcion = descripcion;
		this.idServicio=idServicio;
		this.idEspecialista=idEspecialista;
		this.DNI=DNI;
		this.fecha=fecha;
	    this.hora=hora;
		
	}
	
	public HistorialClinico() {
		super();
		// TODO Auto-generated constructor stub
	
	
}

	public int getIdHistorialClinico() {
		return idHistorialClinico;
	}

	public void setIdHistorialClinico(int idHistorialClinico) {
		this.idHistorialClinico = idHistorialClinico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Servicio getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Servicio idServicio) {
		this.idServicio = idServicio;
	}

	public Especialista getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(Especialista idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public Cliente getDNI() {
		return DNI;
	}

	public void setDNI(Cliente dNI) {
		DNI = dNI;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
}