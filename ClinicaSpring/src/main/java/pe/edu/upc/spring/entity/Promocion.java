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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Promocion")
public class Promocion implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromocion;
	
	
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechainicio")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechainicio;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechafin")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechafin;

	@NotEmpty(message = "No puede estar vacÃ­o")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descuento",length=60,nullable=false)
	private double descuento;

	public Promocion(int idPromocion, Date fechainicio, Date fechafin, double descuento) {
		super();
		this.idPromocion = idPromocion;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.descuento = descuento;
	}
	public Promocion() {
		super();
			}
	public int getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
}


