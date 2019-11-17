package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.ProgramacionMensual;

public interface IProgramacionMensualService {

public boolean insertar(ProgramacionMensual ProgramacionMensual);
	
	public boolean modificar(ProgramacionMensual ProgramacionMensual);
	
	public void eliminar(int idProgramacionMensual);
	
	
	public ProgramacionMensual listarId(int idProgramacionMensual); //
	
	public List<ProgramacionMensual> listar();
	
	List<ProgramacionMensual> findByProgramacionMensual(String nombreProgramacionMensual);
	
}