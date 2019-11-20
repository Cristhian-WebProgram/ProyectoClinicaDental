package pe.edu.upc.spring.entity;



import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;







@Entity
@Table(name = "Boleta")
public class Boleta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idboleta;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que todavia NO existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaComprobante",length=60,nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	
	
	@Column(name="medioPago", nullable=false,length=20)
    private String mediopago;
	
	@ManyToOne
	@JoinColumn(name = "idservicio", nullable = false)
	private Servicio idservicio;
	
	@ManyToOne
	@JoinColumn(name = "idreserva", nullable = false)
	private Reserva idreserva;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "boleta_id")
	private List<DetalleBoleta> boletaDetalle;
	
	
	
	
	public Boleta(int idboleta, List<DetalleBoleta> boletaDetalle, Date fecha, String  mediopago, Servicio idservicio, Reserva idreserva) {
		super();
		this.idboleta = idboleta;
		this.fecha = fecha;
		this.mediopago = mediopago;
		this.idreserva = idreserva;
		this.boletaDetalle = boletaDetalle;
		
		
	}
	
	public Boleta() {
		super();
	}
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}

	
	

	public int getIdboleta() {
		return idboleta;
	}

	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMediopago() {
		return mediopago;
	}

	public void setMediopago(String mediopago) {
		this.mediopago = mediopago;
	}

	public Servicio getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(Servicio idservicio) {
		this.idservicio = idservicio;
	}

	public Reserva getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(Reserva idreserva) {
		this.idreserva = idreserva;
	}

	public List<DetalleBoleta> getBoletaDetalle() {
		return boletaDetalle;
	}

	public void setBoletaDetalle(List<DetalleBoleta> boletaDetalle) {
		this.boletaDetalle = boletaDetalle;
	}

	public void addBoletaDetalle(DetalleBoleta item) {
		this.boletaDetalle.add(item);
	}

	public Double getTotal() {

		return boletaDetalle.stream().collect(Collectors.summingDouble(DetalleBoleta::calculateAmount));
	}
	
	
}