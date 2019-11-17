package pe.edu.upc.spring.service;

import java.util.List;


import pe.edu.upc.spring.entity.Consultorio;


public interface IConsultorioService {

	public boolean insertar(Consultorio Consultorio);
	
	public boolean modificar(Consultorio Consultorio);
	
	public void eliminar(int idConsultorio);
	
    public Consultorio listarId(int idConsultorio);
    
 
	
	public List<Consultorio> listar();
	
	List<Consultorio> findByConsultorio(String nombreConsultorio);
	
	
	
	
}
