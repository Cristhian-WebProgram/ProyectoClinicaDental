package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.Servicio;

public interface IServicioService {

public boolean insertar(Servicio Servicio);
	
	public boolean modificar(Servicio Servicio);
	
	public void eliminar(int idServicio);
	
	public Servicio buscarPorId(int idServicio);
	
	
	public Servicio listarId(int idServicio); //
	
	public List<Servicio> listar();
	
	List<Servicio> findByServicio(String nombreServicio);
	
}