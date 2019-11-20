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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "ProgramacionMensual")
public class ProgramacionMensual implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProgramacionMensual;
	
	
	@ManyToOne
	@JoinColumn(name = "idConsultorio", nullable = false)
	private Consultorio idConsultorio;

	@ManyToOne
	@JoinColumn(name = "idHorarioMensual", nullable = false)
	private HorarioMensual idHorarioMensual;
	
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaprogramacion")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaprogramacion;
	
	@Column(name ="estado", length=60, nullable=false)
	private int estado;
	
	public ProgramacionMensual(int idProgramacionMensual, Consultorio idConsultorio, Especialista idEspecialista,HorarioMensual idHorarioMensual , Date fechaprogramacion, int estado ) {
		super();
		this.idProgramacionMensual = idProgramacionMensual;
		this.idConsultorio = idConsultorio;
		this.idHorarioMensual = idHorarioMensual;
		this.fechaprogramacion= fechaprogramacion;
		this.estado=estado;
		
		
	}

	public ProgramacionMensual() {
		super();
		
	}

	public int getIdProgramacionMensual() {
		return idProgramacionMensual;
	}

	public void setIdProgramacionMensual(int idProgramacionMensual) {
		this.idProgramacionMensual = idProgramacionMensual;
	}

	public Consultorio getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Consultorio idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public HorarioMensual getIdHorarioMensual() {
		return idHorarioMensual;
	}

	public void setIdHorarioMensual(HorarioMensual idHorarioMensual) {
		this.idHorarioMensual = idHorarioMensual;
	}

	public Date getFechaprogramacion() {
		return fechaprogramacion;
	}

	public void setFechaprogramacion(Date fechaprogramacion) {
		this.fechaprogramacion = fechaprogramacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	

}
