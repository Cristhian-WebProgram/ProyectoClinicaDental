package pe.edu.upc.spring.entity;


import java.io.Serializable;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "consultorio")

public class Consultorio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultorio;
	
	private int numerodesala;

	public Consultorio(int idConsultorio, int numerodesala) {
		super();
		this.idConsultorio = idConsultorio;
		this.numerodesala = numerodesala;
	}
	
	public Consultorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getNumerodesala() {
		return numerodesala;
	}

	public void setNumerodesala(int numerodesala) {
		this.numerodesala = numerodesala;
	}

	
}
	

