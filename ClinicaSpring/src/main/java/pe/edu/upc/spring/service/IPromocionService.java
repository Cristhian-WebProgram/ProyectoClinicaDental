package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.Promocion;

public interface IPromocionService {

public boolean insertar(Promocion Promocion);
	
	public boolean modificar(Promocion Promocion);
	
	public void eliminar(int idPromocion);
	

	
	public Promocion listarId(int idPromocion); //
	
	public List<Promocion> listar();
	
	List<Promocion> findByPromocion(String nombrePromocion);
	
}