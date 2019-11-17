package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.HistorialClinico;

public interface IHistorialClinicoService {

public boolean insertar(HistorialClinico HistorialClinico);
	
	public boolean modificar(HistorialClinico HistorialClinico);
	
	public void eliminar(int idHistorialClinico);
	
	
	public HistorialClinico listarId(int idHistorialClinico); //
	
	public List<HistorialClinico> listar();
	
	
	List<HistorialClinico> findByHistorialClinico(String nombreHistorialClinico);

	
}