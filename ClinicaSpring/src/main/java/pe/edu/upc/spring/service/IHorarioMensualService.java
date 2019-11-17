package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.HorarioMensual;

public interface IHorarioMensualService {

public boolean insertar(HorarioMensual HorarioMensual);
	
	public boolean modificar(HorarioMensual HorarioMensual);
	
	public void eliminar(int idHorarioMensual);
	
	
	
	public HorarioMensual listarId(int idHorarioMensual); //
	
	public List<HorarioMensual> listar();
	
	List<HorarioMensual> findByHorarioMensual(String nombreHorarioMensual);


}