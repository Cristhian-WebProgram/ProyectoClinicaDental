package pe.edu.upc.spring.entity;


import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;




@Entity
@Table(name = "detalleboleta")
public class DetalleBoleta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetalleboleta;
	
	@Column(name="cantidadservicios",length =60,nullable=false)
	private int cantidadservicios;
	
    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio idServicio;
    
    @ManyToOne
    @JoinColumn(name = "idBoleta", nullable = false)
    private Boleta idBoleta;

    @ManyToOne
    @JoinColumn(name = "idpromocion", nullable = false)
     private Promocion idPromocion;
    

    
    public DetalleBoleta(int iddetalleboleta, int cantidadservicios, List<Boleta> boleta, Servicio idServicio,Promocion idPromocion ) {
		super();
		this.iddetalleboleta = iddetalleboleta;
		this.cantidadservicios = cantidadservicios;
	
		this.idServicio = idServicio;
		this.idPromocion = idPromocion;
	}
	public DetalleBoleta() {
		super();
	}
	public int getIddetalleboleta() {
		return iddetalleboleta;
	}
	public void setIddetalleboleta(int iddetalleboleta) {
		this.iddetalleboleta = iddetalleboleta;
	}
	public int getCantidadservicios() {
		return cantidadservicios;
	}
	public void setCantidadservicios(int cantidadservicios) {
		this.cantidadservicios = cantidadservicios;
	}
	public Servicio getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Servicio idServicio) {
		this.idServicio = idServicio;
	}
	public Boleta getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(Boleta idBoleta) {
		this.idBoleta = idBoleta;
	}
	public Promocion getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(Promocion idPromocion) {
		this.idPromocion = idPromocion;
	}
public Double calculateAmount() {
		
		return cantidadservicios*idServicio.getCosto();
  
}
}
