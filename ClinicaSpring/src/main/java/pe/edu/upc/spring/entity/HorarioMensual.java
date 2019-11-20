package pe.edu.upc.spring.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "HorarioMensual")
public class HorarioMensual implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHorarioMensual;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="horainicio",length =60,nullable=false)
	private int horainicio;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="horafin",length =60,nullable=false)
	private int horafin;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="numerodias",length =60,nullable=false)
	private int numerodias;
	
	@ManyToOne
	@JoinColumn(name = "idespecialista", nullable = false)
	private Especialista idEspecialista;


	public HorarioMensual(int idHorarioMensual, int horainicio,int horafin, Especialista idEspecialista, Cliente DNI, int numerodias ) {
		super();
		this.idHorarioMensual = idHorarioMensual;
		this.horainicio = horainicio;
		this.horafin=horafin;
		this.idEspecialista=idEspecialista;
		this.numerodias=numerodias;

	}
	
	public HorarioMensual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdHorarioMensual() {
		return idHorarioMensual;
	}

	public void setIdHorarioMensual(int idHorarioMensual) {
		this.idHorarioMensual = idHorarioMensual;
	}

	public int getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}

	public int getHorafin() {
		return horafin;
	}

	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}

	public int getNumerodias() {
		return numerodias;
	}

	public void setNumerodias(int numerodias) {
		this.numerodias = numerodias;
	}

	public Especialista getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(Especialista idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

}