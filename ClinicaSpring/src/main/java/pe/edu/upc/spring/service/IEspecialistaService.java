package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.Especialista;

public interface IEspecialistaService {

public boolean insertar(Especialista Especialista);
	
	public boolean modificar(Especialista Especialista);
	
	public void eliminar(int idEspecialista);
	
	
	public Especialista listarId(int idEspecialista); //
	
	public List<Especialista> listar();
	
	public List<Especialista> findByEspecialista(String nombreEspecialista);

	
}
