package pe.edu.upc.spring.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Reserva",uniqueConstraints = { @UniqueConstraint(columnNames = {  "nombreReserva" }) })
public class Reserva implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@NotEmpty(message = "No puede estar vacío")
	@Column(name = "nombrereserva", length = 60, nullable = false)
	private String nombreReserva;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechareserva")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechareserva;

	
	@ManyToOne
	@JoinColumn(name = "DNI", nullable = false)
	private Cliente DNI;
	
	@ManyToOne
	@JoinColumn(name = "idhistorialclinico", nullable = false)
	private HistorialClinico historialclinico;
	
	@ManyToOne
	@JoinColumn(name = "idprogramacionmensual", nullable = false)
	private ProgramacionMensual idprogramacionmensual;
	
	@Column(name ="horareserva", length=60, nullable=false)
	private int horareserva;
	
	
	
	public Reserva(int idReserva, String nombreReserva, Date fechareserva 
			, Cliente DNI,HistorialClinico historialclinico, ProgramacionMensual idprogramacionmensual, int horareserva ) {
		super();
		this.idReserva = idReserva;
		this.nombreReserva = nombreReserva;
		this.fechareserva = fechareserva;
		this.horareserva=horareserva;
		this.DNI=DNI;
		this.historialclinico = historialclinico;
		this.idprogramacionmensual=idprogramacionmensual;
	
	}
	
	public Reserva() {
		super();
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public Date getFechareserva() {
		return fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}

	public Cliente getDNI() {
		return DNI;
	}

	public void setDNI(Cliente dNI) {
		DNI = dNI;
	}

	public HistorialClinico getHistorialclinico() {
		return historialclinico;
	}

	public void setHistorialclinico(HistorialClinico historialclinico) {
		this.historialclinico = historialclinico;
	}

	public ProgramacionMensual getIdprogramacionmensual() {
		return idprogramacionmensual;
	}

	public void setIdprogramacionmensual(ProgramacionMensual idprogramacionmensual) {
		this.idprogramacionmensual = idprogramacionmensual;
	}

	public int getHorareserva() {
		return horareserva;
	}

	public void setHorareserva(int horareserva) {
		this.horareserva = horareserva;
	}

	

}

	