package pe.edu.upc.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "Servicio",uniqueConstraints = { @UniqueConstraint(columnNames = {  "nombre" }) })
public class Servicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservicio;
	
	@NotEmpty(message ="No puede estar vacio")
	@NotBlank(message ="No puede estar en blanco")
	@Column(name="nombre",length =60,nullable=false)
	private String nombre;
	
	
	@Column(name ="descripcion", length=60, nullable=false)
	private String descripcion;
	
	
	@DecimalMin("1.00")
	@Column(name = "costo", columnDefinition = "Decimal(8,2)", nullable = false)
	private double costo;

	public Servicio(int idservicio,String nombre, String descripcion, double costo) {
		super();
		this.idservicio = idservicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	public Servicio() {
		super();
		
	}
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
}